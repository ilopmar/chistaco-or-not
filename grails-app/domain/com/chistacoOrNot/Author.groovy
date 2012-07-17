package com.chistacoOrNot

class Author {
    
    String name
    
    static constraints = {
    }
    
    static hasMany = [jokes:Joke]
    
}
