package com.coding.batchProcessingChallenge.dto;

public class RecommedFriendDTO  implements Comparable{

	private long userId;

    private String text;

	private Long replyToUserId;

	private Long retweetedStatus;

	private Long retweetedToUserId;

	private Long tweetId;
    
	private int hashtagCount;
	
	private double hashtagScore;

	private int replyCount;

	private int retweetCount;
	
	private double interactionScore;
	
	private int keywordCount;

	private double keywordScore;
	
    private double score;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public int getKeywordCount() {
		return keywordCount;
	}

	public void setKeywordCount(int keywordCount) {
		this.keywordCount = keywordCount;
	}

	public double getKeywordScore() {
		return keywordScore;
	}

	public void setKeywordScore(double keywordScore) {
		this.keywordScore = keywordScore;
	}
	
	@Override
    public int compareTo(Object comparestu) {
        int compareage=(int) ((RecommedFriendDTO)comparestu).getScore();
       
        /* For Descending order */
        return (int) (compareage-this.score);
    }

	
}
