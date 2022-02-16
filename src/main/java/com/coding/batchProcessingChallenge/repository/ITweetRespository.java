package com.coding.batchProcessingChallenge.repository;

import com.coding.batchProcessingChallenge.domain.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITweetRespository  extends JpaRepository<Tweet, Long>  {
}
