package com.coding.batchProcessingChallenge.dto;

import com.coding.batchProcessingChallenge.domain.User;

public class InteractionCountDTO {

	private User userId;

	private Long replyToUserId;

	private Long retweetedToUserId;

	private int replyCount;

	private int retweetCount;
	
	private double interactionScore;

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

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public int getRetweetCount() {
		return retweetCount;
	}

	public void setRetweetCount(int retweetCount) {
		this.retweetCount = retweetCount;
	}

	public double getInteractionScore() {
		return interactionScore;
	}

	public void setInteractionScore(double interactionScore) {
		this.interactionScore = interactionScore;
	}

	


}
