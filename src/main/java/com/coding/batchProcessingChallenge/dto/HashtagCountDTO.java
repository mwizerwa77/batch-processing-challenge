package com.coding.batchProcessingChallenge.dto;

import com.coding.batchProcessingChallenge.domain.User;

public class HashtagCountDTO {

	private User userId;

	private Long replyToUserId;

	private Long retweetedToUserId;

	private String hashtag;
	
	private int hashtagCount;
	
	private double hashtagScore;

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

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public int getHashtagCount() {
		return hashtagCount;
	}

	public void setHashtagCount(int hashtagCount) {
		this.hashtagCount = hashtagCount;
	}

	public double getHashtagScore() {
		return hashtagScore;
	}

	public void setHashtagScore(double hashtagScore) {
		this.hashtagScore = hashtagScore;
	}

}
