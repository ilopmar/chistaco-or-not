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

    /**
     * Return the jokes with more points
     *
     * @return a list with the jokes with more points
     */
    public List<Joke> ranking() {
        def ranking = Joke.withCriteria {

            gt 'points', 0

            order 'points', 'desc'

            maxResults 30
            cache true
        }
    }
}
