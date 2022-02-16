package com.coding.batchProcessingChallenge.repository;

import com.coding.batchProcessingChallenge.domain.TweetHashtagEntity;
import com.coding.batchProcessingChallenge.domain.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUrlEntityRespository extends JpaRepository<UrlEntity, Long>  {
    Optional<UrlEntity> findByUrl(String url);
}
