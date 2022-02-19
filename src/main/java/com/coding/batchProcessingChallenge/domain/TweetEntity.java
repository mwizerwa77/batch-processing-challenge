package com.coding.batchProcessingChallenge.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class TweetEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("hashtags")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tweet_entity_hashtags", joinColumns = @JoinColumn(name = "tweet_entity_id"), inverseJoinColumns = @JoinColumn(name = "hashtag_id"))
    private List<TweetHashtagEntity> tweetHashtags;

    @JsonProperty("user_mentions")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tweet_entity_user_mentions", joinColumns = @JoinColumn(name = "tweet_entity_id"), inverseJoinColumns = @JoinColumn(name = "user_mention_id"))
    private List<UserMention> userMentions;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tweet_entity_symbols", joinColumns = @JoinColumn(name = "tweet_entity_id"), inverseJoinColumns = @JoinColumn(name = "symbol_id"))
    private List<TweetHashtagEntity> symbols;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tweet_entity_urls", joinColumns = @JoinColumn(name = "tweet_entity_id"), inverseJoinColumns = @JoinColumn(name = "url_entity_id"))
    private List<UrlEntity> urls;

    private boolean favorited;

    private boolean retweeted;

    @JsonProperty("possibly_sensitive")
    private boolean possiblySensitive;

    @JsonProperty("filter_level")
    private String filterLevel;

    private String lang;

    @JsonIgnore
    private String media;

    @Override
    public String toString() {
        return "TweetEntity{" +
                "id=" + id +
                ", tweetHashtags=" + tweetHashtags.size() +
                ", userMentions=" + userMentions.size() +
                ", symbols=" + symbols.size() +
                ", urls=" + urls.size() +
                ", favorited=" + favorited +
                ", retweeted=" + retweeted +
                ", possiblySensitive=" + possiblySensitive +
                ", filterLevel='" + filterLevel + '\'' +
                ", lang='" + lang + '\'' +
                ", media='" + media + '\'' +
                '}';
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TweetHashtagEntity> getTweetHashtags() {
        return tweetHashtags;
    }

    public void setTweetHashtags(List<TweetHashtagEntity> tweetHashtags) {
        this.tweetHashtags = tweetHashtags;
    }

    public List<UserMention> getUserMentions() {
        return userMentions;
    }

    public void setUserMentions(List<UserMention> userMentions) {
        this.userMentions = userMentions;
    }

    public List<TweetHashtagEntity> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<TweetHashtagEntity> symbols) {
        this.symbols = symbols;
    }

    public List<UrlEntity> getUrls() {
        return urls;
    }

    public void setUrls(List<UrlEntity> urls) {
        this.urls = urls;
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
}
