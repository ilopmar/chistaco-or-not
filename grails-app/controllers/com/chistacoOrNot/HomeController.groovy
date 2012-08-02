package com.chistacoOrNot

import grails.converters.JSON


class HomeController {
    
    static methodsAllowed = [vote:"POST"]
    
    def jokeService
	def twitterService

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
	
	def test() {
		twitterService.getTweets(1)
//		def a1 = new Author(name:'Pepe', twitter:"pepe", twitterId:"1111111", avatar:"avatar1")
//		def j1 = new Joke(description:'Lorem ipsum dolor sit amet consectetur adipiscing elit nam aliquet facilisis nunc sit amet suscipit nisi blandit vitae sed scelerisque tincidunt nisi et scelerisque donec molestie eros sit amet ante ultricies tincidunt morbi rhoncus nisi neque... aaaaaa', externalJokeId:"aa")
//		a1.addToJokes(j1)
//		a1.save()
//		println a1.errors
		
		render 'hola'
	}
}
