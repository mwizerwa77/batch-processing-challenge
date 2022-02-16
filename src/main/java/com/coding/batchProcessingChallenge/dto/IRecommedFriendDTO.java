/**
 *
 */
package com.coding.batchProcessingChallenge.dto;

import com.coding.batchProcessingChallenge.domain.Tweet;

/**
 * @author Stanley
 * @date 2022-Feb-16 11:16:31 AM
 */
public interface IRecommedFriendDTO {

    Long getUserId();

    String getScreenName();

    String getDescription();

    Tweet getQuotedStatus();

    Tweet getRetweetedStatus();

}
