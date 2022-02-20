package com.coding.batchProcessingChallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coding.batchProcessingChallenge.service.TweetService;

@CrossOrigin
@RestController
public class EndpointController {


    @Autowired
    private TweetService tweetService;
    
    
    @GetMapping(value = "/q2", params = {"user_id", "type", "phrase", "hashtag"})
    public ResponseEntity<?> getById(@RequestParam(value = "user_id") Long userId,
                                                @RequestParam(value = "type") String type,
                                                @RequestParam(value = "phrase") String phrase,
                                                @RequestParam(value = "hashtag") String hashtag) {
        
        return ResponseEntity.ok(tweetService.getRecommendedFriends(userId, type, phrase, hashtag));
    }

}
