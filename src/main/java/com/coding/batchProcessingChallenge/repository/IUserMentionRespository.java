package com.coding.batchProcessingChallenge.repository;

import com.coding.batchProcessingChallenge.domain.TweetHashtagEntity;
import com.coding.batchProcessingChallenge.domain.UserMention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserMentionRespository extends JpaRepository<UserMention, Long>  {
}
