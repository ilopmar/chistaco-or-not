package com.chistacoOrNot

class Joke {

    static belongsTo = [author:Author]

    /**
     * The twitter id of the status
     */
	String statusId

    /**
     * The text of the 'chistaco'
     */
    String text

    /**
     * Total points
     */
    Integer points = 0

    /**
     * Creation date of the joke
     */
    Date dateCreated

    /**
     * Last update
     */
    Date lastUpdated
    
    static constraints = {
    }

    static mapping = {
        version false
        cache true

        // Indexes
        statusId index: 'joke__statusId_idx'
    }
    
    public String toString() {
        return text
    }
}
