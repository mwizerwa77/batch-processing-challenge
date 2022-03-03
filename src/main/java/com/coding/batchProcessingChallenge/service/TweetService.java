package com.coding.batchProcessingChallenge.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.batchProcessingChallenge.domain.User;
import com.coding.batchProcessingChallenge.dto.IHashtagCountDTO;
import com.coding.batchProcessingChallenge.dto.IRecommendFriendDTO;
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

		if (user.isPresent()) {
			return tweetRespository.recommendFriends(user.get(), userId, hashtag, phrase).size()+"";
		}

		List<RecommedFriendDTO> recommendFriendsList = new ArrayList<RecommedFriendDTO>();
		
		try {
			List<IRecommendFriendDTO> recommendFriends = tweetRespository.recommendFriends(user.get(), userId, hashtag, phrase);

			recommendFriends.forEach(item ->{

				RecommedFriendDTO entity = new RecommedFriendDTO(item.getUserId().getId(), item.getText(), item.getReplyToUserId(), item.getRetweetedStatus(), item.getRetweetedToUserId(), item.getTweetId(), item.getReplyCount(), item.getRetweetCount(), item.getKeywordCount());
				
				// calculate interaction score
				double interactionScore = Math.log(1 + (item.getReplyCount() * 2) + item.getRetweetCount());
				entity.setInteractionScore(interactionScore);

				// calculate keyword count
				double keywordScore;
				if ((item.getKeywordCount() + item.getHashtagCount()) > 0) {
					keywordScore = 1 + Math.log((item.getKeywordCount() + item.getHashtagCount()) + 1);
				} else {
					keywordScore = 0;
				}
				entity.setKeywordScore(keywordScore);

				// calculate hashtag count
				List<IHashtagCountDTO> hashtagCounts = tweetRespository.getHashtagCount(user.get(), userId);

				hashtagCounts.forEach(hashtagCount -> {

					if (hashtagCount.getUserId().getId() == item.getUserId().getId()
							&& (hashtagCount.getReplyToUserId() == item.getReplyToUserId()
									|| hashtagCount.getRetweetedToUserId() == item.getRetweetedToUserId())) {
						double hashtagScore;
						if (hashtagCount.getHashtagCount() > 10) {
							hashtagScore = 1 + Math.log(1 + (hashtagCount.getHashtagCount() - 10));
						} else {
							hashtagScore = 1;
						}

						entity.setHashtagCount(hashtagCount.getHashtagCount());
						entity.setHashtagScore(hashtagScore);

						hashtagCounts.remove(hashtagCount);
						return;
					}

				});

				// calculate total score
				double score = entity.getInteractionScore() * entity.getHashtagScore() * entity.getKeywordScore();
				entity.setScore(score);
				recommendFriendsList.add(entity);
			});
			
			
			return processResponseText(userId, recommendFriendsList);
		
			//recommendFriends = ;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "No recommended friends found";
		
	}
	
	public List<IRecommendFriendDTO> getFriends(User user, String type, String phrase, String hashtag) {
		return tweetRespository.recommendFriends(user, user.getId(), hashtag, phrase);
	}

	@SuppressWarnings("unchecked")
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
