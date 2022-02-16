package com.coding.batchProcessingChallenge.controller;

import com.coding.batchProcessingChallenge.domain.UserMention;
import com.coding.batchProcessingChallenge.dto.IRecommedFriendDTO;
import com.coding.batchProcessingChallenge.repository.ITweetRespository;
import com.coding.batchProcessingChallenge.repository.IUserMentionRespository;
import com.coding.batchProcessingChallenge.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;

@CrossOrigin
@RestController
public class EndpointController {


    @Autowired
    private TweetService tweetService;

    @GetMapping(value = "/q2", params = {"user_id", "type", "phrase", "hashtag"})
    public ResponseEntity<String> getById(@RequestParam(value = "user_id") Long userId,
                                          @RequestParam(value = "type") String type,
                                          @RequestParam(value = "phrase") String phrase,
                                          @RequestParam(value = "hashtag") String hashtag) {

        return ResponseEntity.ok(tweetService.fetchRecommededFriends(userId, type, hashtag, phrase));
    }

}
