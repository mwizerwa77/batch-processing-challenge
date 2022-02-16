package com.coding.batchProcessingChallenge.repository;

import com.coding.batchProcessingChallenge.domain.TweetHashtagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHashtagRespository extends JpaRepository<TweetHashtagEntity, Long>  {
}
