package com.coding.batchProcessingChallenge.processor;

import com.coding.batchProcessingChallenge.domain.Tweet;
import com.coding.batchProcessingChallenge.domain.User;
import org.springframework.batch.item.ItemProcessor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TweetProcessor implements ItemProcessor<Tweet,Tweet> {

    @Override
    public Tweet process(Tweet item) throws Exception {
        final User user = item.getUser();
        if(item.getText().length()==0 ||
                (item.getId()==0 && item.getIdStr()==null) ||
                (user.getId()==0 && user.getIdStr()==null) ||
                item.getEntities().getTweetHashtags().isEmpty() || item.getCreatedAt() ==null){
            throw new RuntimeException("Invalid tweet");
        }else{

            SimpleDateFormat formatter=new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");

            try {
                item.setCreateAtTime(formatter.parse(item.getCreatedAt()));
                user.setCreateAtTime(formatter.parse(user.getCreatedAt()));

                item.setUser(user);
                
                if(item.getRetweetedStatus()!=null) {
                	Tweet retweetingTo = item.getRetweetedStatus();
                	retweetingTo.setCreateAtTime(formatter.parse(retweetingTo.getCreatedAt()));
                	User retweetingToUser  = retweetingTo.getUser();
                	retweetingToUser.setCreateAtTime(formatter.parse(retweetingToUser.getCreatedAt()));
                	retweetingTo.setUser(retweetingToUser);
                	item.setRetweetedStatus(retweetingTo);
                }
            } catch (ParseException e) {
                throw new RuntimeException("Invalid tweet");
            }
        }

        return item;
    }

}
