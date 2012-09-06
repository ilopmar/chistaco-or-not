package com.chistacoOrNot

class Joke {

    static belongsTo = [author:Author]

    /**
     * The internal id of the joke
     */
    String jId = UUID.randomUUID().toString().replaceAll('-', '')
    
    /**
     * The text of the 'chistaco'
     */
    String text

    /**
     * The twitter id of the status
     */
	String externalJokeId

    /**
     * Total points
     */
    Integer points = 0
    
    static constraints = {
    }

    static mapping = {
        version false
        cache true
    }
    
    public String toString() {
        return description
    }
}
