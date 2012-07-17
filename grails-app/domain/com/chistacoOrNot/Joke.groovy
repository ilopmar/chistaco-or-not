package com.chistacoOrNot

class Joke {
    
    String description
    
    static constraints = {
    }
    
    static mapping = {
        description type:"text"
    }
    
    static belongsTo = [author:Author]
}
