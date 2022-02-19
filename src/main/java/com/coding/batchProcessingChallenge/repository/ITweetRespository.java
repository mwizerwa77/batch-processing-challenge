package com.coding.batchProcessingChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coding.batchProcessingChallenge.domain.Tweet;
import com.coding.batchProcessingChallenge.domain.User;
import com.coding.batchProcessingChallenge.dto.IRecommedFriendDTO;

@Repository
public interface ITweetRespository  extends JpaRepository<Tweet, Long>  {

    @Query("SELECT t.id as tweetId,t.user as userId,t.text as text,t.inReplyToUserId as replyToUserId,COALESCE(t.retweetedStatus.id,0) as retweetedStatus FROM Tweet t where t.user=:user OR t.inReplyToUserId=:userId")
    Iterable<IRecommedFriendDTO> findTweetById(@Param("user") User user,@Param("userId") Long userId);

}
