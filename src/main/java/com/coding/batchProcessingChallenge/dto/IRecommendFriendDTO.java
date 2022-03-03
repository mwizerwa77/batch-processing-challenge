package com.coding.batchProcessingChallenge.dto;

import com.coding.batchProcessingChallenge.domain.User;

public interface IRecommendFriendDTO {

	User getUserId();

	String getText();

	Long getReplyToUserId();

	Long getRetweetedStatus();

	Long getRetweetedToUserId();

	Long getTweetId();

	Integer getHashtagCount();

	Double getHashtagScore();

	Integer getReplyCount();

	Integer getRetweetCount();

	Double getInteractionScore();

	Integer getKeywordCount();

	Double getKeywordScore();

	Double getScore();

}
