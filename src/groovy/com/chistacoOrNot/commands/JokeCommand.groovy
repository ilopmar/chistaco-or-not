package com.chistacoOrNot.commands

import com.chistacoOrNot.Joke

/**
* Command Object to check the jokes
*/
@grails.validation.Validateable
class JokeCommand  {
	String j1
	String j2

    static constraints = {
    	j1 nullable:false, validator: { val, obj -> 
    		Joke.findByStatusId(val) != null
    	}
    	j2 nullable:false, validator: { val, obj -> 
			Joke.findByStatusId(val) != null
    	}
    }

    public Joke getJoke1() {
    	return Joke.findByStatusId(j1)
    }

    public Joke getJoke2() {
    	return Joke.findByStatusId(j2)
    }
}
