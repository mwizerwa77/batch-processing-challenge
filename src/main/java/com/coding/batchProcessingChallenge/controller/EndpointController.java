package com.coding.batchProcessingChallenge.controller;

import com.coding.batchProcessingChallenge.domain.UserMention;
import com.coding.batchProcessingChallenge.repository.IUserMentionRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class EndpointController {


	@Autowired
	private IUserMentionRespository userMentionRespository;

	@GetMapping("/q2/{id}")
	public List<UserMention> getById(@Param(value = "id") long id) {

		return userMentionRespository.findAll();
	}

}
