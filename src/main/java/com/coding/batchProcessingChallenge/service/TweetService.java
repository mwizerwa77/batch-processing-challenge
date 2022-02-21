package com.coding.batchProcessingChallenge.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.batchProcessingChallenge.domain.User;
import com.coding.batchProcessingChallenge.dto.HashtagCountDTO;
import com.coding.batchProcessingChallenge.dto.RecommedFriendDTO;
import com.coding.batchProcessingChallenge.repository.ITweetRespository;
import com.coding.batchProcessingChallenge.repository.IUserRespository;

@Service
public class TweetService {

	private ITweetRespository tweetRespository;

	@Autowired
	private IUserRespository userRespository;

	public String getRecommendedFriends(Long userId, String type, String phrase, String hashtag) {

		Optional<User> user = userRespository.findById(userId);

		if (!user.isPresent()) {
			return "User not found";
		}


		List<RecommedFriendDTO> recommendFriendsList = new ArrayList<RecommedFriendDTO>();
		
		Iterable<RecommedFriendDTO> recommendFriends = null;
		
		try {
			recommendFriends = tweetRespository.recommendFriends(user.get(), userId, hashtag,
					phrase);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		if(recommendFriends !=null) {
			recommendFriends.forEach(item ->{

				// calculate interaction score
				double interactionScore = Math.log(1 + (item.getReplyCount() * 2) + item.getRetweetCount());
				item.setInteractionScore(interactionScore);

				// calculate keyword count
				double keywordScore;
				if ((item.getKeywordCount() + item.getHashtagCount()) > 0) {
					keywordScore = 1 + Math.log((item.getKeywordCount() + item.getHashtagCount()) + 1);
				} else {
					keywordScore = 0;
				}
				item.setKeywordScore(keywordScore);

				// calculate hashtag count
				List<HashtagCountDTO> hashtagCounts = tweetRespository.getHashtagCount(user.get(), userId);

				hashtagCounts.forEach(hashtagCount -> {

					if (hashtagCount.getUserId().getId() == item.getUserId()
							&& (hashtagCount.getReplyToUserId() == item.getReplyToUserId()
									|| hashtagCount.getRetweetedToUserId() == item.getRetweetedToUserId())) {
						double hashtagScore;
						if (hashtagCount.getHashtagCount() > 10) {
							hashtagScore = 1 + Math.log(1 + (hashtagCount.getHashtagCount() - 10));
						} else {
							hashtagScore = 1;
						}

						item.setHashtagCount(hashtagCount.getHashtagCount());
						item.setHashtagScore(hashtagScore);

						hashtagCounts.remove(hashtagCount);
						return;
					}

				});

				// calculate total score
				double score = item.getInteractionScore() * item.getHashtagScore() * item.getKeywordScore();
				item.setScore(score);
				recommendFriendsList.add(item);
			});
			
			
			return processResponseText(userId, recommendFriendsList);
		}
		
		
		return "No recommended friends found";
		
	}

	private String processResponseText(Long userId, List<RecommedFriendDTO> recommendFriends) {
		
		//sort items by score value
		Collections.sort(recommendFriends);
				
		//process the response text
		String friends="No recommended friends found";
		for(RecommedFriendDTO item: recommendFriends) {
			
			 friends="TeamCoolCloud,1234-0000-0001";
			
			if(item.getScore()>0) {
				if(item.getUserId()!=userId) {
					Optional<User> friend = userRespository.findById(item.getUserId());

					if (friend.isPresent()) {
						friends =friends+ "\n"+item.getUserId()+"\t"+friend.get().getScreenName()+"\t"+friend.get().getDescription()+"\t"+item.getText();	
					}	
				}
				if(item.getReplyToUserId()!=0) {
					Optional<User> friend = userRespository.findById(item.getReplyToUserId());

					if (friend.isPresent()) {
						friends =friends+ "\n"+item.getUserId()+"\t"+friend.get().getScreenName()+"\t"+friend.get().getDescription()+"\t"+item.getText();	
					}	
				}
				
				if(item.getRetweetedToUserId()!=0) {
					Optional<User> friend = userRespository.findById(item.getRetweetedToUserId());

					if (friend.isPresent()) {
						friends =friends+ "\n"+item.getUserId()+"\t"+friend.get().getScreenName()+"\t"+friend.get().getDescription()+"\t"+item.getText();	
					}	
				}
				
				
			}
		}
		return friends;
	}

}
