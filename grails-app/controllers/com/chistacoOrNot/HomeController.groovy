package com.chistacoOrNot

import grails.converters.JSON

class HomeController {
    
    def jokeService
	def twitterService

    /**
     * Get two random jokes and set their ids in the session
     */
    private nextJokes() {
        def randomJokes = jokeService.nextJokes()
        def j1 = randomJokes[0]
        def j2 = randomJokes[1]

        // Save the jIds in the session to check them when voting
        session['CHISTACO_J1'] = j1.statusId
        session['CHISTACO_J2'] = j2.statusId

        return [j1, j2]
    }

    /**
     * Main page. Render two random jokes
     */
    def jokes() {
        def list = this.nextJokes()

        render view:'jokes', model:[j1:list[0], j2:list[1]]
    }
    
    /**
     * Vote for a joke
     *
     * @param j1 The joke voted
     * @param j2 The joke not voted
     */
    def vote(String j1, String j2) {

        // Check that both jokes exists
        def joke1 = Joke.findByStatusId(j1)
        def joke2 = Joke.findByStatusId(j2)

        if (!joke1 || !joke2) {
            return render(text:[success:false, msg:'Alguno de los chistes no existe'] as JSON, contentType:'text/json')
        }

        def sessionJ1 = session['CHISTACO_J1']
        def sessionJ2 = session['CHISTACO_J2']
        // If the jIds are not the same as session do not count the vote
        if (!((sessionJ1 == joke1.statusId && sessionJ2 == joke2.statusId) 
            || (sessionJ1 == joke2.statusId && sessionJ2 == joke1.statusId))) {
            return render(text:[success:false, msg:'Chistes no válidos'] as JSON, contentType:'text/json')
        }
        
        // Vote!
        def result = jokeService.vote(joke1)

        // Get new jokes
        def list = this.nextJokes()
        def html = g.render template:'jokes', model:[j1:list[0], j2:list[1]]
        
        return render(text:[success:true, msg:'Voto contabilizado correctamente', html:html] as JSON, contentType:'text/json')
    }

    /**
     * Ranking of the best jokes
     */
    def ranking() {
        def ranking = jokeService.ranking()

        render view:'ranking', model:[ranking:ranking]
    }

    /**
     * Load new jokes
     *
     * @param j1 The id of the 1st joke
     * @param j2 The id of the 2nd joke
     */
    def refresh(String j1, String j2) {
        // Check that both jokes exists
        def joke1 = Joke.findByStatusId(j1)
        def joke2 = Joke.findByStatusId(j2)

        if (!joke1 || !joke2) {
            return render(text:[success:false, msg:'Alguno de los chistes no existe'] as JSON, contentType:'text/json')
        }

        def sessionJ1 = session['CHISTACO_J1']
        def sessionJ2 = session['CHISTACO_J2']
        // If the jIds are not the same as session do not count the vote
        if (!((sessionJ1 == joke1.statusId && sessionJ2 == joke2.statusId) 
            || (sessionJ1 == joke2.statusId && sessionJ2 == joke1.statusId))) {
            return render(text:[success:false, msg:'Chistes no válidos'] as JSON, contentType:'text/json')
        }

        // Get new jokes
        def list = this.nextJokes()
        def html = g.render template:'jokes', model:[j1:list[0], j2:list[1]]

        return render(text:[success:true, html:html] as JSON, contentType:'text/json')
    }

}
