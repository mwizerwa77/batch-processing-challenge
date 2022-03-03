package com.coding.batchProcessingChallenge.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coding.batchProcessingChallenge.domain.User;
import com.coding.batchProcessingChallenge.dto.IHashtagCountDTO;
import com.coding.batchProcessingChallenge.dto.IRecommendFriendDTO;
import com.coding.batchProcessingChallenge.dto.RecommedFriendDTO;
import com.coding.batchProcessingChallenge.repository.ITweetRespository;
import com.coding.batchProcessingChallenge.repository.IUserRespository;


@CrossOrigin
@RestController
public class EndpointController {


	private final Logger logger = LoggerFactory.getLogger(EndpointController.class);

    @Autowired
    private ITweetRespository tweetRepository;
    
    @Autowired
    private IUserRespository userRespository;
    
    @GetMapping(value = "/q2", params = {"user_id", "type", "phrase", "hashtag"})
    public ResponseEntity<?> getById(@RequestParam(value = "user_id") Long userId,
                                                @RequestParam(value = "type") String type,
                                                @RequestParam(value = "phrase") String phrase,
                                                @RequestParam(value = "hashtag") String hashtag) {
    	Optional<User> user = userRespository.findById(userId);

		if (!user.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}

        return ResponseEntity.ok(recommendedFriendsString(user.get(), type, phrase, hashtag));
    }
    
    @GetMapping(value = "/q2/hashtag", params = {"user_id", "type", "phrase", "hashtag"})
    public ResponseEntity<?> getByHashtagCount(@RequestParam(value = "user_id") Long userId,
                                                @RequestParam(value = "type") String type,
                                                @RequestParam(value = "phrase") String phrase,
                                                @RequestParam(value = "hashtag") String hashtag) {
        
    	Optional<User> user = userRespository.findById(userId);

		if (!user.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
		
        return ResponseEntity.ok(tweetRepository.getHashtagCount(user.get(), userId));
    }
    
    @GetMapping(value = "/q2/friends", params = {"user_id", "type", "phrase", "hashtag"})
    public ResponseEntity<?> getRecommendedFriends(@RequestParam(value = "user_id") Long userId,
                                                @RequestParam(value = "type") String type,
                                                @RequestParam(value = "phrase") String phrase,
                                                @RequestParam(value = "hashtag") String hashtag) {
        
    	Optional<User> user = userRespository.findById(userId);

		if (!user.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
		return ResponseEntity.ok(tweetRepository.recommendFriends(user.get(), userId, hashtag, phrase));
    }
    
    private String recommendedFriendsString(User user,String type, String phrase, String hashtag) {

		
List<RecommedFriendDTO> recommendFriendsList = new ArrayList<RecommedFriendDTO>();
		
		List<IRecommendFriendDTO> recommendFriends = tweetRepository.recommendFriends(user, user.getId(), hashtag, phrase);
		
		System.out.println("Size:..............."+recommendFriends.size());
		
		
		for(IRecommendFriendDTO item: recommendFriends){

			RecommedFriendDTO entity = new RecommedFriendDTO();
			entity.setUserId(item.getUserId().getId());
			entity.setText(item.getText());
			try {
				entity.setReplyToUserId(item.getReplyToUserId());
			} catch (Exception e) {
				
				logger.error(e.getMessage());
			}
			try {
				entity.setRetweetedStatus(item.getRetweetedStatus());
			} catch (Exception e2) {
				
				logger.error(e2.getMessage());
			}
			try {
				entity.setRetweetedToUserId(item.getRetweetedToUserId());
			} catch (Exception e1) {
				
				logger.error(e1.getMessage());
			}
			try {
				entity.setTweetId(item.getTweetId());
			} catch (Exception e1) {
				
				logger.error(e1.getMessage());
			}
			
			try {
				entity.setReplyCount(item.getReplyCount());
			} catch (Exception e) {
				
				logger.error(e.getMessage());
			}
			try {
				entity.setRetweetCount(item.getRetweetCount());
			} catch (Exception e) {
				
				logger.error(e.getMessage());
			}
			try {
				entity.setKeywordCount(item.getKeywordCount());
			} catch (Exception e) {
				
				logger.error(e.getMessage());
			}
			
			// calculate interaction score
			double interactionScore = 0;
			try {
				interactionScore = Math.log(1 + (item.getReplyCount() * 2) + item.getRetweetCount());
			} catch (Exception e) {
				
				logger.error(e.getMessage());
			}
			entity.setInteractionScore(interactionScore);

			// calculate keyword count
			double keywordScore = 0;
			if ((item.getKeywordCount() + item.getHashtagCount()) > 0) {
				keywordScore = 1 + Math.log((item.getKeywordCount() + item.getHashtagCount()) + 1);
			}
			entity.setKeywordScore(keywordScore);

			// calculate hashtag count
			List<IHashtagCountDTO> hashtagCounts = tweetRepository.getHashtagCount(user, user.getId());

			for(IHashtagCountDTO hashtagCount: hashtagCounts){

				if (hashtagCount.getUserId().getId() == item.getUserId().getId()
						&& (hashtagCount.getReplyToUserId() == item.getReplyToUserId()
								|| hashtagCount.getRetweetedToUserId() == item.getRetweetedToUserId())) {
					double hashtagScore = 1;
					if (hashtagCount.getHashtagCount() > 10) {
						hashtagScore = 1 + Math.log(1 + (hashtagCount.getHashtagCount() - 10));
					} 

					entity.setHashtagCount(hashtagCount.getHashtagCount());
					entity.setHashtagScore(hashtagScore);

					hashtagCounts.remove(hashtagCount);
					break;
				}

			}

			// calculate total score
			double score = entity.getInteractionScore() * entity.getHashtagScore() * entity.getKeywordScore();
			entity.setScore(score);
			recommendFriendsList.add(entity);
			
			return processResponseText(user.getId(), recommendFriendsList);
		}
		
		return "No recommended friends found";
		
	}
    
    @SuppressWarnings("unchecked")
	private String processResponseText(Long userId, List<RecommedFriendDTO> recommendFriends) {
		
		//sort items by score value
		Collections.sort(recommendFriends);
				
		//process the response text
		String friends="No recommended friends found";
		for(RecommedFriendDTO item: recommendFriends) {
			
			 friends="TeamCoolCloud,1234-0000-0001";
			
			/*if(item.getScore()>0) {
				
			}*/

				if(item.getUserId()!=userId) {
					Optional<User> friend = userRespository.findById(item.getUserId());

					if (friend.isPresent()) {
						friends =friends+ "\n"+item.getUserId()+"\t"+friend.get().getScreenName()+"\t"+friend.get().getDescription()+"\t"+item.getText();	
					}	
				}
				if(item.getReplyToUserId()!= null) {
					Optional<User> friend = userRespository.findById(item.getReplyToUserId());

					if (friend.isPresent()) {
						friends =friends+ "\n"+item.getUserId()+"\t"+friend.get().getScreenName()+"\t"+friend.get().getDescription()+"\t"+item.getText();	
					}	
				}
				
				if(item.getRetweetedToUserId()!= null) {
					Optional<User> friend = userRespository.findById(item.getRetweetedToUserId());

					if (friend.isPresent()) {
						friends =friends+ "\n"+item.getUserId()+"\t"+friend.get().getScreenName()+"\t"+friend.get().getDescription()+"\t"+item.getText();	
					}	
				}
				
				
			
		}
		return friends;
	}

}
