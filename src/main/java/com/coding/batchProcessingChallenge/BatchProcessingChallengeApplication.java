package com.coding.batchProcessingChallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BatchProcessingChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchProcessingChallengeApplication.class, args);
	}

}
