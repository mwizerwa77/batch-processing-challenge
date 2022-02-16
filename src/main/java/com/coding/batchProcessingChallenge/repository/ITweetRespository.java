package com.coding.batchProcessingChallenge.repository;

import com.coding.batchProcessingChallenge.domain.Tweet;
import com.coding.batchProcessingChallenge.dto.IRecommedFriendDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITweetRespository  extends JpaRepository<Tweet, Long>  {

    @Query("SELECT t.userId as userId,p.screenName as screenName,p.description as description,t.retweetedStatus as retweetedStatus,t.quotedStatus as quotedStatus FROM Tweet t JOIN User p ON t.userId = p.id  JOIN TweetEntity u ON t.entities = u.id " +
            "JOIN TweetHashtagEntity h ON u.tweetHashtags=h.id where t.userId=:userId AND h.text=:hashtag")
    List<IRecommedFriendDTO> fetchRecommededFriends(@Param("userId") Long userId,@Param("hashtag") String hashtag,@Param("phrase") String phrase);
}
