package com.coding.batchProcessingChallenge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.batchProcessingChallenge.domain.User;
import com.coding.batchProcessingChallenge.dto.HashtagCountDTO;
import com.coding.batchProcessingChallenge.dto.IRecommedFriendDTO;
import com.coding.batchProcessingChallenge.dto.InteractionCountDTO;
import com.coding.batchProcessingChallenge.dto.KeywordCountDTO;
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

        if(!user.isPresent()) {
        	 return "User not found";
        }
		
        Iterable<RecommedFriendDTO> recommendFriends = tweetRespository.recommendFriends(user.get(), userId);
        
        Iterable<HashtagCountDTO> hashtagCounts = tweetRespository.getHashtagCount(user.get(), userId);
        List<HashtagCountDTO> hashtagCountList =  new ArrayList<>();
        hashtagCounts.forEach(hashtagCount ->{
        	double hashtagScore;
        	if(hashtagCount.getHashtagCount()>10) {
        		hashtagScore = 1 + Math.log(1 +(hashtagCount.getHashtagCount()-10));
        	}else {
        		hashtagScore = 1;
        	}
        	hashtagCount.setHashtagScore(hashtagScore);
        	hashtagCountList.add(hashtagCount);
		});
        
		Iterable<KeywordCountDTO> keyWordAndHashtagCounts = tweetRespository.getKeyWordAndHashtagCount(user.get(), userId, hashtag, phrase);
		List<KeywordCountDTO> keywordCountList = new ArrayList<>();
		//keywords_score = 1 + log(number_of_matches + 1)
		keyWordAndHashtagCounts.forEach(keywordCount->{
			double keywordScore;
			if((keywordCount.getHashtagCount()+keywordCount.getHashtagCount())>0) {
				keywordScore = 1 + Math.log((keywordCount.getHashtagCount()+keywordCount.getHashtagCount())+1);
			}else {
				keywordScore = 0;
			}
			keywordCount.setKeywordScore(keywordScore);
			keywordCountList.add(keywordCount);
			
		});
		
		Iterable<InteractionCountDTO> interactionCounts = tweetRespository.getInteractionCount(user.get(), userId);
		List<InteractionCountDTO> interactionCountList = new ArrayList<>();
		interactionCounts.forEach(interactionCount->{
			double interactionScore = Math.log(1+(interactionCount.getReplyCount()*2)+interactionCount.getRetweetCount());
			interactionCount.setInteractionScore(interactionScore);
			interactionCountList.add(interactionCount);
			
		});
		
		recommendFriends.forEach(rommendedFriend ->{
			// add to score
			double score;
			//get interaction per pair of users
			for(InteractionCountDTO interaction: interactionCountList) {
				if(interaction.getUserId().equals(rommendedFriend.getUserId()) && interaction.getReplyToUserId().equals(rommendedFriend.getReplyToUserId())) {
					
				}
			}
		});
		
		return null;
	}

}
