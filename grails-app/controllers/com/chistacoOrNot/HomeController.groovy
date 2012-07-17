package com.chistacoOrNot

import grails.converters.JSON

class HomeController {
    
    static methodsAllowed = [vote:"POST"]
    
    def jokeService

    def jokes() {
        def randomJokes = jokeService.nextJokes()
        def j1 = randomJokes[0]
        def j2 = randomJokes[1]
        
        render view:'jokes', model:[j1:j1, j2:j2]
    }
    
    def vote(Long id) {
        def joke = Joke.get(id)
        if (!joke) {
            return render(text:[success:false] as JSON, contentType:'text/json')
        }
        
        def result = jokeService.vote(joke)
        
        return render(text:[success:result] as JSON, contentType:'text/json')
    }
}
