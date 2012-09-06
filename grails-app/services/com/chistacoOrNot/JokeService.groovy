package com.chistacoOrNot

class JokeService {
    
    static transactional = false

    /**
     * Return two random jokes
     *
     * @return two random jokes
     */    
    public List<Joke> nextJokes() {
        def jokes = Joke.withCriteria {
            sqlRestriction "1=1 order by random()"
            maxResults 2
        }

        return jokes
    }

    /**
     * Add a point to a joke
     *
     * @param The joke to vote
     * @return true when done
     */
    public Boolean vote(Joke joke) {
        joke.points++
        joke.save()
        
        return true
    }
}
