package com.coding.batchProcessingChallenge.controller;

import com.coding.batchProcessingChallenge.domain.Tweet;
import com.coding.batchProcessingChallenge.domain.User;
import com.coding.batchProcessingChallenge.domain.UserMention;
import com.coding.batchProcessingChallenge.dto.FetchRecommendedFriend;
import com.coding.batchProcessingChallenge.dto.IRecommedFriendDTO;
import com.coding.batchProcessingChallenge.repository.ITweetRespository;
import com.coding.batchProcessingChallenge.repository.IUserMentionRespository;
import com.coding.batchProcessingChallenge.repository.IUserRespository;
import com.coding.batchProcessingChallenge.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class EndpointController {


    @Autowired
    private TweetService tweetService;
    
    @Autowired
    private ITweetRespository tweetRepo;
    

    @Autowired
    private IUserRespository userRepo;
    
    
    @GetMapping(value = "/q2", params = {"user_id", "type", "phrase", "hashtag"})
    public ResponseEntity<?> getById(@RequestParam(value = "user_id") Long userId,
                                                @RequestParam(value = "type") String type,
                                                @RequestParam(value = "phrase") String phrase,
                                                @RequestParam(value = "hashtag") String hashtag) {
        
        Optional<User> user = userRepo.findById(userId);

        if(!user.isPresent()) {
        	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found user");
        }
        return ResponseEntity.ok(tweetRepo.findTweetById(user.get(),user.get().getId()));
    }

}
