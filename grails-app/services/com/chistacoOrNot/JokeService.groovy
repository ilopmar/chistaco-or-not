package com.chistacoOrNot

class JokeService {
    
    static transactional = true
    
    public List<Joke> nextJokes() {
        def jokeIds = Joke.withCriteria {
            projections {
                property('id')
            }
        }
        
        def randomList = jokeIds.sort { Math.random() }
        def joke1 = Joke.get(randomList[0])
        def joke2 = Joke.get(randomList[1])
        
        return [joke1, joke2]
    }

    public Boolean vote(Joke joke) {
        joke.points++
        joke.save()
        
        return true
    }
}
