package com.coding.batchProcessingChallenge.dto;

import com.coding.batchProcessingChallenge.domain.Tweet;

public class FetchRecommendedFriend {

   private long userId;

    /*private long inReplyToUserId;

    private long retweetToUserId;

    private String text;

    private long retweetedId;

    private String screenName;

    private String description;*/


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
/*
    public Long getInReplyToUserId() {
        return inReplyToUserId;
    }

    public void setInReplyToUserId(Long inReplyToUserId) {
        this.inReplyToUserId = inReplyToUserId;
    }

    public Long getRetweetToUserId() {
        return retweetToUserId;
    }

    public void setRetweetToUserId(Long retweetToUserId) {
        this.retweetToUserId = retweetToUserId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getRetweetedId() {
        return retweetedId;
    }

    public void setRetweetedId(Long retweetedId) {
        this.retweetedId = retweetedId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }*/

}
