package com.coding.batchProcessingChallenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coding.batchProcessingChallenge.domain.Tweet;
import com.coding.batchProcessingChallenge.domain.User;
import com.coding.batchProcessingChallenge.dto.RecommedFriendDTO;
import com.coding.batchProcessingChallenge.dto.HashtagCountDTO;

@Repository
public interface ITweetRespository  extends JpaRepository<Tweet, Long>  {

    
    @Query("SELECT t.id as tweetId,t.user as userId,t.text as text,t.inReplyToUserId as replyToUserId,COALESCE(t.retweetedStatus.id,0) as retweetedStatus,COALESCE(t.retweetedStatus.user.id,0) as retweetedToUserId,COUNT(t.inReplyToUserId) AS replyCount,COUNT(t.retweetedStatus.user.id) AS retweetedCount,h.text as hashtag,COUNT(h.text) as hashtagCount,ROUND ((LENGTH(t.text) - LENGTH( REPLACE ( t.text, :keyword, '') ) ) / LENGTH(:keyword)) AS keywordCount FROM Tweet t JOIN TweetEntity e ON t.entities=e.id JOIN e.tweetHashtags h where h.text=:hashtag AND t.retweetedStatus.user=:user OR t.user=:user OR t.inReplyToUserId=:userId GROUP BY t.user,t.inReplyToUserId,t.retweetedStatus.user.id")
    List<RecommedFriendDTO> recommendFriends(@Param("user") User user,@Param("userId") Long userId,@Param("hashtag") String hashtag, @Param("keyword") String keyword);

    @Query("SELECT t.user as userId,t.inReplyToUserId as replyToUserId, COALESCE(t.retweetedStatus.user.id,0) as retweetedToUserId,h.text as hashtag, COUNT(h.text) as hashtagCount FROM Tweet t JOIN TweetEntity e ON t.entities=e.id JOIN e.tweetHashtags h where t.retweetedStatus.user=:user OR t.user=:user OR t.inReplyToUserId=:userId GROUP BY h.text")
    List<HashtagCountDTO> getHashtagCount(@Param("user") User user,@Param("userId") Long userId);

  
}
