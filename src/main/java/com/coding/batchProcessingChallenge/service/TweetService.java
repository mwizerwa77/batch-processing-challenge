package com.coding.batchProcessingChallenge.service;

import com.coding.batchProcessingChallenge.dto.IRecommedFriendDTO;
import com.coding.batchProcessingChallenge.repository.ITweetRespository;
import org.springframework.stereotype.Service;

@Service
public class TweetService {

    private ITweetRespository tweetRespository;

    public String fetchRecommededFriends(Long userId, String type,String hashtag,String phrase){
        String rcmFriends ="TeamCoolCloud,1234-0000-0001";
        for(IRecommedFriendDTO dto:tweetRespository.fetchRecommededFriends(userId, hashtag,phrase)){
            String contactTweetText="";
            if(type.equalsIgnoreCase("retweet")){
                contactTweetText = dto.getRetweetedStatus().getText();
            }else  if(type.equalsIgnoreCase("reply")){
                contactTweetText = dto.getQuotedStatus().getText();
            }else{
                contactTweetText = dto.getRetweetedStatus().getText()+" "+dto.getQuotedStatus().getText();
            }
            String item =dto.getUserId()+"\t"+dto.getScreenName()+"\t"+dto.getDescription()+"\t"+contactTweetText;
            rcmFriends = rcmFriends+"\n"+item;
        }

        return rcmFriends;
    }
}
