package com.coding.batchProcessingChallenge.dto;

public class RecommedFriendDTO {

	private long userId;

    private long retweetToUserId;

    private String text;

	private Long replyToUserId;

	private Long retweetedStatus;

	private Long retweetedToUserId;

	private Long tweetId;
    
    private double score;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getRetweetToUserId() {
		return retweetToUserId;
	}

	public void setRetweetToUserId(long retweetToUserId) {
		this.retweetToUserId = retweetToUserId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getReplyToUserId() {
		return replyToUserId;
	}

	public void setReplyToUserId(Long replyToUserId) {
		this.replyToUserId = replyToUserId;
	}

	public Long getRetweetedStatus() {
		return retweetedStatus;
	}

	public void setRetweetedStatus(Long retweetedStatus) {
		this.retweetedStatus = retweetedStatus;
	}

	public Long getRetweetedToUserId() {
		return retweetedToUserId;
	}

	public void setRetweetedToUserId(Long retweetedToUserId) {
		this.retweetedToUserId = retweetedToUserId;
	}

	public Long getTweetId() {
		return tweetId;
	}

	public void setTweetId(Long tweetId) {
		this.tweetId = tweetId;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
    
}
