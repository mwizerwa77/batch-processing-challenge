package com.coding.batchProcessingChallenge.dto;

import com.coding.batchProcessingChallenge.domain.User;

public interface IHashtagCountDTO {

	User getUserId();

	Long getReplyToUserId();

	Long getRetweetedToUserId();

	String getHashtag();

	Integer getHashtagCount();

	Double getHashtagScore();

}
