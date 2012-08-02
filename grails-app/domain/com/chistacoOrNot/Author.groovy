package com.chistacoOrNot

class Author {
    
    String name
	String twitter
	String twitterId
	String avatar
    
    static constraints = {
    }
    
    static hasMany = [jokes:Joke]

    public String toString() {
        return name
    }    
}
