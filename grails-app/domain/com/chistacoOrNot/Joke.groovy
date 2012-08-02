package com.chistacoOrNot

class Joke {
    
    String description
	String externalJokeId
    Integer points = 0
    
    static constraints = {
    }
    
    static mapping = {
        //id generator:'uuid'
        description type:"text"
    }
    
    static belongsTo = [author:Author]
    
    public String toString() {
        return description
    }
}
