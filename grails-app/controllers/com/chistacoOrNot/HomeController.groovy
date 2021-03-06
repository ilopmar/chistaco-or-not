package com.chistacoOrNot

import grails.converters.JSON
import com.chistacoOrNot.commands.JokeCommand

class HomeController {
    
    def jokeService
	def twitterService

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
    def vote(JokeCommand cmd) {
        if (!cmd.validate()) {
            return render(text:[success:false, msg:'Alguno de los chistes no existe'] as JSON, contentType:'text/json')
        }

        if (!this.checkSessionJokes(cmd.joke1, cmd.joke2)) {
            return render(text:[success:false, msg:'Chistes no válidos'] as JSON, contentType:'text/json')
        }
        
        // Vote: Best joke +1 and the other joke -1
        jokeService.vote(cmd.joke1)
        jokeService.vote(cmd.joke2, -1)

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
    def refresh(JokeCommand cmd) {
        if (!cmd.validate()) {
            return render(text:[success:false, msg:'Alguno de los chistes no existe'] as JSON, contentType:'text/json')
        }

        if (!this.checkSessionJokes(cmd.joke1, cmd.joke2)) {
            return render(text:[success:false, msg:'Chistes no válidos'] as JSON, contentType:'text/json')
        }

        // Penalize both jokes
        jokeService.vote(cmd.joke1, -3)
        jokeService.vote(cmd.joke2, -3)

        // Get new jokes
        def list = this.nextJokes()
        def html = g.render template:'jokes', model:[j1:list[0], j2:list[1]]

        return render(text:[success:true, html:html] as JSON, contentType:'text/json')
    }



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
     * Check that both received jokes are the previously stored in the session
     */
    private boolean checkSessionJokes(Joke joke1, Joke joke2) {
        def sessionJ1 = session['CHISTACO_J1']
        def sessionJ2 = session['CHISTACO_J2']
        // If the jIds are not the same as session do not count the vote
        if (!((sessionJ1 == joke1.statusId && sessionJ2 == joke2.statusId) 
            || (sessionJ1 == joke2.statusId && sessionJ2 == joke1.statusId))) {
            return false
        }

        return true
    }

}
