/**
 *
 */
package com.coding.batchProcessingChallenge.dto;

import com.coding.batchProcessingChallenge.domain.User;

/**
 * @author Stanley
 * @date 2022-Feb-16 11:16:31 AM
 */
public interface IInteractionCountDTO {

	// SELECT t.id as tweetId,t.user as userId,t.text as text,t.inReplyToUserId as
	// replyToUserId,t.retweetedStatus as retweetId
	User getUserId();

	Long getReplyToUserId();

	Long getRetweetedToUserId();

	int getReplyCount();

	int getRetweetCount();
	
	int getInteractionScore();

}
