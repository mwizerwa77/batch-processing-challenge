package com.coding.batchProcessingChallenge.repository;

import com.coding.batchProcessingChallenge.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRespository extends CrudRepository<User, Long> {

}
