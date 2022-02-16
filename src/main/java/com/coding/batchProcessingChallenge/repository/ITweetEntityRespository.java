package com.coding.batchProcessingChallenge.repository;

import com.coding.batchProcessingChallenge.domain.TweetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITweetEntityRespository extends JpaRepository<TweetEntity, Long>  {
}
