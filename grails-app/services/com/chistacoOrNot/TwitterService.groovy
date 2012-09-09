package com.chistacoOrNot

import groovy.json.JsonSlurper

class TwitterService {

	public void getTweets(int pages = 10) {
		for (i in 1..pages) {
			this.getTweetsFromPage(i)
		}
	}
	
	/**
	 * Find tweets in twitter with the hashtag #chistaco
	 *
	 * @param page The page in twitter to search for jokes
	 */
	private void getTweetsFromPage(int page) {
		def slurper = new JsonSlurper()

		log.info "Getting new tweets from Twitter - start"

		try {
			def url = "http://search.twitter.com/search.json?q=%23chistaco&rpp=100&page=${page}"
			def content = new URL(url).getText("UTF-8")
			def response = slurper.parseText(content)

			response.results.each { tweet ->
				
				// Ignore the tweet if contains a RT or a '@'
				if (!tweet.text.contains("RT") && !tweet.text.contains("@")) {
					
					// Check if the author already exists
					def author = Author.findByTwitterId(tweet.from_user_id)
					if (!author) {
						author = new Author(name:tweet.from_user_name, twitter:tweet.from_user, twitterId:tweet.from_user_id, avatar:tweet.profile_image_url)
					}
					
					// Check if the joke already exists
					def joke = Joke.findByStatusId(tweet.id)
					if (!joke) {
						joke = new Joke(text:tweet.text, statusId:tweet.id)
						author.addToJokes(joke)
					}

					author.save()
				}
			}
		} catch (Exception e) {
			log.error "There was an error with twitter"
		}

		log.info "Getting new tweets from Twitter - end"
	}
}
