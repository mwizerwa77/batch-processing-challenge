package com.coding.batchProcessingChallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.batchProcessingChallenge.domain.Tweet;
import com.coding.batchProcessingChallenge.domain.User;
import com.coding.batchProcessingChallenge.repository.ITweetRespository;
import com.coding.batchProcessingChallenge.repository.IUserRespository;

@Service
public class TweetService {

    private ITweetRespository tweetRespository;

    @Autowired
    private IUserRespository userRespository;

  
    /*public List<IRecommedFriendDTO> fetchRecommededFriends(Long userId){
         List<IRecommedFriendDTO> iRecommedFriendDTOS = new ArrayList<>();
        try {
            Optional<User> user = userRespository.findById(userId);
            if(!user.isPresent()){
                throw new NullPointerException("User not found");
            }
            iRecommedFriendDTOS = tweetRespository.fetchRecommededFriends(user.get().getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iRecommedFriendDTOS;
    }*/


    public String fetchRecommededFriendsWithSupportedLanguage(Long userId, String type, String hashtag, String phrase, List<String> list) {

        return null;
    }

	public Iterable<User> findAll() {
		return userRespository.findAll();
	}

	/*public Long findAllTweets() {
		
		Long id = Long.parseLong("451954866139590656");
		
		return tweetRespository.findTweetById(id).get();
	}*/
}
