package com.chistacoOrNot

class JokeService {
    
    static transactional = true

    public Boolean vote(Joke joke) {
        joke.points++
        joke.save()
        
        return true
    }
}
