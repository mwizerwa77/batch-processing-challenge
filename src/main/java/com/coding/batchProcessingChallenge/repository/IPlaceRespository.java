package com.coding.batchProcessingChallenge.repository;

import com.coding.batchProcessingChallenge.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPlaceRespository extends JpaRepository<Place, Long>  {
    boolean existsByExtId(String extId);

    Optional<Place> findByExtId(String extId);
}
