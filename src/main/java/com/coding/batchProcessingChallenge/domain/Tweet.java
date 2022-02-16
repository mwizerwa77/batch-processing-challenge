package com.coding.batchProcessingChallenge.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class Tweet implements Serializable {

    @JsonProperty("created_at")
    private String createdAt;

    @Id
    private Long id;

    @JsonProperty("id_str")
    private String idStr;

    @Column(columnDefinition = "TEXT")
    private String text;

    private boolean truncated;

    @JsonProperty("in_reply_to_status_id")
    private Long inReplyToStatusId;

    @JsonProperty("in_reply_to_status_id_str")
    private String inReplyToStatusIdStr;

    @JsonProperty("in_reply_to_user_id")
    private Long inReplyToUserId;

    @JsonProperty("in_reply_to_user_id_str")
    private String inReplyToUserIdStr;

    @JsonProperty("in_reply_to_screen_name")
    private String inReplyToScreenName;

    @JsonIgnore
    private String contributors;

    @ManyToOne
    private Geometry coordinates;

    @ManyToOne
    private Place place;

    @JsonProperty("retweet_count")
    private int retweetCount;

    @JsonProperty("favorite_count")
    private int favoriteCount;

    private boolean favorited;

    private boolean retweeted;

    @JsonProperty("possibly_sensitive")
    private boolean possiblySensitive;

    @JsonProperty("filter_level")
    private String filterLevel;

    @Transient
    @JsonProperty("retweeted_status")
    private Tweet retweetedStatus;

    @Transient
    @JsonProperty("quoted_status")
    private Tweet quotedStatus;

    private String lang;

    @ManyToOne
    private User user;

    @ManyToOne
    private TweetEntity entities;

    private  String source;

    @JsonIgnore
    private String geo;


    @Override
    public String toString() {
        return "Tweet{" +
                "createdAt='" + createdAt + '\'' +
                ", id=" + id +
                ", idStr='" + idStr + '\'' +
                ", text='" + text + '\'' +
                ", truncated=" + truncated +
                ", inReplyToStatusId=" + inReplyToStatusId +
                ", inReplyToStatusIdStr='" + inReplyToStatusIdStr + '\'' +
                ", inReplyToUserId=" + inReplyToUserId +
                ", inReplyToUserIdStr='" + inReplyToUserIdStr + '\'' +
                ", inReplyToScreenName='" + inReplyToScreenName + '\'' +
                ", contributors='" + contributors + '\'' +
                ", coordinates=" + coordinates +
                ", place=" + place +
                ", retweetCount=" + retweetCount +
                ", favoriteCount=" + favoriteCount +
                ", favorited=" + favorited +
                ", retweeted=" + retweeted +
                ", possiblySensitive=" + possiblySensitive +
                ", filterLevel='" + filterLevel + '\'' +
                ", retweetedStatus=" + retweetedStatus +
                ", quotedStatus=" + quotedStatus +
                ", lang='" + lang + '\'' +
                ", user=" + user +
                ", entities=" + entities +
                ", source='" + source + '\'' +
                ", geo='" + geo + '\'' +
                '}';
    }

    public Tweet getRetweetedStatus() {
        return retweetedStatus;
    }

    public void setRetweetedStatus(Tweet retweetedStatus) {
        this.retweetedStatus = retweetedStatus;
    }

    public Tweet getQuotedStatus() {
        return quotedStatus;
    }

    public void setQuotedStatus(Tweet quotedStatus) {
        this.quotedStatus = quotedStatus;
    }

    public String getContributors() {
        return contributors;
    }

    public void setContributors(String contributors) {
        this.contributors = contributors;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isTruncated() {
        return truncated;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

    public Long getInReplyToStatusId() {
        return inReplyToStatusId;
    }

    public void setInReplyToStatusId(Long inReplyToStatusId) {
        this.inReplyToStatusId = inReplyToStatusId;
    }

    public String getInReplyToStatusIdStr() {
        return inReplyToStatusIdStr;
    }

    public void setInReplyToStatusIdStr(String inReplyToStatusIdStr) {
        this.inReplyToStatusIdStr = inReplyToStatusIdStr;
    }

    public Long getInReplyToUserId() {
        return inReplyToUserId;
    }

    public void setInReplyToUserId(Long inReplyToUserId) {
        this.inReplyToUserId = inReplyToUserId;
    }

    public String getInReplyToUserIdStr() {
        return inReplyToUserIdStr;
    }

    public void setInReplyToUserIdStr(String inReplyToUserIdStr) {
        this.inReplyToUserIdStr = inReplyToUserIdStr;
    }

    public String getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    public void setInReplyToScreenName(String inReplyToScreenName) {
        this.inReplyToScreenName = inReplyToScreenName;
    }

    public Geometry getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Geometry coordinates) {
        this.coordinates = coordinates;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public boolean isRetweeted() {
        return retweeted;
    }

    public void setRetweeted(boolean retweeted) {
        this.retweeted = retweeted;
    }

    public boolean isPossiblySensitive() {
        return possiblySensitive;
    }

    public void setPossiblySensitive(boolean possiblySensitive) {
        this.possiblySensitive = possiblySensitive;
    }

    public String getFilterLevel() {
        return filterLevel;
    }

    public void setFilterLevel(String filterLevel) {
        this.filterLevel = filterLevel;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TweetEntity getEntities() {
        return entities;
    }

    public void setEntities(TweetEntity entities) {
        this.entities = entities;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
