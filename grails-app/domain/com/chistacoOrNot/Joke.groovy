package com.chistacoOrNot

class Joke {
    
    String description
    Integer points = 0
    
    static constraints = {
    }
    
    static mapping = {
        description type:"text"
    }
    
    static belongsTo = [author:Author]
    
    public String toString() {
        return description
    }
}
