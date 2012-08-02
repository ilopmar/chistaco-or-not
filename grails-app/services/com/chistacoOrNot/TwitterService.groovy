package com.chistacoOrNot

import groovy.json.JsonSlurper

class TwitterService {

	public void getTweets(int pages = 10) {
		for (i in 1..pages) {
			this.getTweetsFromPage(i)
		}
	}
	
	private void getTweetsFromPage(int page) {
		def slurper = new JsonSlurper()

		def url = "http://search.twitter.com/search.json?q=%23chistaco&rpp=100&page=${page}"
		def content = new URL(url).getText("UTF-8")
		def response = slurper.parseText(content)

		def c = 0
		response.results.each { tweet ->
			
			// Ignore the tweet if contains a RT or a '@'
			if (!tweet.text.contains("RT") && !tweet.text.contains("@")) {
				
				println "-"*60
				println tweet.text
				println tweet.id
				println "@${tweet.from_user} (${tweet.from_user_name})"
				println tweet.profile_image_url
				println tweet.from_user_id
				println "-"*60

				def author = new Author(name:tweet.from_user_name, twitter:tweet.from_user, 
					twitterId:tweet.from_user_id, avatar:tweet.profile_image_url)
				
				def joke = new Joke(description:tweet.text, externalJokeId:tweet.id)
				
				author.addToJokes(joke)
				author.save()
				
				c++
			}
		}
		
		println "Total = ${c}"

	}
}
