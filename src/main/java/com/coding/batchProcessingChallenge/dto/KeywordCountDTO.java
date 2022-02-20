package com.coding.batchProcessingChallenge.dto;

import com.coding.batchProcessingChallenge.domain.User;

public class KeywordCountDTO {
	
	private Long tweetId;
	
	private User userId;

	private Long replyToUserId;

	private Long retweetedToUserId;

	private int keywordCount;

	private int hashtagCount;
	
	private double keywordScore;

	public Long getTweetId() {
		return tweetId;
	}

	public void setTweetId(Long tweetId) {
		this.tweetId = tweetId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Long getReplyToUserId() {
		return replyToUserId;
	}

	public void setReplyToUserId(Long replyToUserId) {
		this.replyToUserId = replyToUserId;
	}

	public Long getRetweetedToUserId() {
		return retweetedToUserId;
	}

	public void setRetweetedToUserId(Long retweetedToUserId) {
		this.retweetedToUserId = retweetedToUserId;
	}

	public int getKeywordCount() {
		return keywordCount;
	}

	public void setKeywordCount(int keywordCount) {
		this.keywordCount = keywordCount;
	}

	public int getHashtagCount() {
		return hashtagCount;
	}

	public void setHashtagCount(int hashtagCount) {
		this.hashtagCount = hashtagCount;
	}

	public double getKeywordScore() {
		return keywordScore;
	}

	public void setKeywordScore(double keywordScore) {
		this.keywordScore = keywordScore;
	}
}
