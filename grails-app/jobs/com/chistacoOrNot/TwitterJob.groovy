package com.chistacoOrNot

class TwitterJob {

	def twitterService

    static triggers = {
		// Every 30 minutes
        cron name: 'loadTweets', cronExpression: "0 */30 * ? * *"
        // Every minute (only for testing)
        // cron name: 'loadTweets', cronExpression: "0 * * ? * *"
    }

    def execute() {
		twitterService.getTweets(15)
    }
}
