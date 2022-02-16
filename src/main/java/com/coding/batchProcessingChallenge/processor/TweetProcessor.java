package com.coding.batchProcessingChallenge.processor;

import com.coding.batchProcessingChallenge.domain.Tweet;
import org.springframework.batch.item.ItemProcessor;

public class TweetProcessor implements ItemProcessor<Tweet,Tweet> {

    @Override
    public Tweet process(Tweet item) throws Exception {
        //Thread.sleep(300);
        System.out.println("Processing a tweet:...idstr:"+item.getIdStr());
        System.out.println("Processing a tweet user id:...."+item.getUser().getId());
        try {
            System.out.println("Processing a tweet entities hastags size..:"+item.getEntities().getTweetHashtags());
        } catch (Exception e) {
            System.out.println("Processing a tweet entities..:null");
            //e.printStackTrace();
        }

        System.out.println("place............."+item.getPlace());

        return item;
    }

}
