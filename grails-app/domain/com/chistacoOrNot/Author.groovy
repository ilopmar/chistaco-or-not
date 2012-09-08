package com.chistacoOrNot

class Author {
    
    /**
     * The full twitter name. E.g: Iván López
     */
    String name

    /**
     * The twitter name without the @
     */
	String twitter

    /**
     * The twitter id
     */
	String twitterId

    /**
     * Full path to the twitter avatar
     */
	String avatar
    
    static constraints = {
    }

    static mapping = {
        version false
        cache true

        // Indexes
        twitterId index: 'author__twitterId_idx'
    }
    
    static hasMany = [jokes:Joke]

    public String toString() {
        return name
    }    
}
