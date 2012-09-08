package com.chistacoOrNot

import grails.converters.JSON

class HomeController {
    
    def jokeService
	def twitterService

    /**
     * Main page. Render two random jokes
     */
    def jokes() {
        def randomJokes = jokeService.nextJokes()
        def j1 = randomJokes[0]
        def j2 = randomJokes[1]

        // Save the jIds in the session to check them when voting
        session['CHISTACO_J1'] = j1.jId
        session['CHISTACO_J2'] = j2.jId

        render view:'jokes', model:[j1:j1, j2:j2]
    }
    
    /**
     * Vote for a joke
     *
     * @param j1 The joke voted
     * @param j2 The joke not voted
     */
    def vote(String j1, String j2) {

        // Check that both jokes exists
        def joke1 = Joke.findByJId(j1)
        def joke2 = Joke.findByJId(j2)

        if (!joke1 || !joke2) {
            return render(text:[success:false, msg:'Alguno de los chistes no existe'] as JSON, contentType:'text/json')
        }

        def sessionJ1 = session['CHISTACO_J1']
        def sessionJ2 = session['CHISTACO_J2']
        // If the jIds are not the same as session do not count the vote
        if (!((sessionJ1 == joke1.jId && sessionJ2 == joke2.jId) || (sessionJ1 == joke2.jId && sessionJ2 == joke1.jId))) {
            return render(text:[success:false, msg:'Chistes no válidos'] as JSON, contentType:'text/json')
        }
        
        // Vote!
        def result = jokeService.vote(joke1)
        
        return render(text:[success:true, msg:'Voto contabilizado correctamente'] as JSON, contentType:'text/json')
    }

    /**
     * Ranking of the best jokes
     */
    def ranking() {
        def ranking = jokeService.ranking()

        render view:'ranking', model:[ranking:ranking]
    }

}
