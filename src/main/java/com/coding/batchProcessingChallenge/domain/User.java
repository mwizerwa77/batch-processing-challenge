package com.coding.batchProcessingChallenge.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class User implements Serializable {

    @JsonProperty("id")
    @Id
    private Long id;

    @JsonProperty("id_str")
    private String idStr;

    private String name;

    @JsonProperty("screen_name")
    private String screenName;

    private String location;

    private String description;

    private String url;

    @JsonProperty("protected")
    private boolean tProtected;

    @JsonProperty("followers_count")
    private int followersCount;

    @JsonProperty("friends_count")
    private int friendsCount;

    @JsonProperty("listed_count")
    private int listedCount;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("favourites_count")
    private int favouritesCount;

    @JsonProperty("utc_offset")
    private String utcOffset;

    @JsonProperty("time_zone")
    private String timeZone;

    @JsonProperty("geo_enabled")
    private boolean geoEnabled;

    private boolean verified;

    @JsonProperty("statuses_count")
    private int statusesCount;

    private String lang;

    @JsonProperty("contributors_enabled")
    private boolean contributorsEnabled;

    @JsonProperty("is_translator")
    private boolean isTranslator;

    @JsonProperty("is_translation_enabled")
    private boolean isTranslationEnabled;

    @JsonProperty("profile_background_color")
    private String profileBackgroundColor;

    @JsonProperty("profile_background_image_url")
    private String profileBackgroundImageUrl;

    @JsonProperty("profile_background_image_url_https")
    private String profileBackgroundImageUrlHttps;

    @JsonProperty("profile_background_tile")
    private String profileBackgroundTile;

    @JsonProperty("profile_image_url")
    private String profileImageUrl;

    @JsonProperty("profile_image_url_https")
    private String profileImageUrlHttps;

    @JsonProperty("profile_banner_url")
    private String profileBannerUrl;

    @JsonProperty("profile_link_color")
    private String profileLinkColor;

    @JsonProperty("profile_sidebar_border_color")
    private String profileSidebarBorderColor;

    @JsonProperty("profile_sidebar_fill_color")
    private String profileSidebarFillColor;

    @JsonProperty("profile_text_color")
    private String profileTextColor;

    @JsonProperty("profile_use_background_image")
    private String profileUseBackgroundImage;

    @JsonProperty("default_profile_image")
    private boolean defaultProfileImage;

    private String following;

    @JsonProperty("follow_request_sent")
    private boolean followRequestSent;

    private String notifications;

    @JsonProperty("translator_type")
    private String translatorType;

    @JsonProperty("default_profile")
    private boolean defaultProfile;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", idStr='" + idStr + '\'' +
                ", name='" + name + '\'' +
                ", screenName='" + screenName + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", tProtected=" + tProtected +
                ", followersCount=" + followersCount +
                ", friendsCount=" + friendsCount +
                ", listedCount=" + listedCount +
                ", createdAt='" + createdAt + '\'' +
                ", favouritesCount=" + favouritesCount +
                ", utcOffset='" + utcOffset + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", geoEnabled=" + geoEnabled +
                ", verified=" + verified +
                ", statusesCount=" + statusesCount +
                ", lang='" + lang + '\'' +
                ", contributorsEnabled=" + contributorsEnabled +
                ", isTranslator=" + isTranslator +
                ", isTranslationEnabled=" + isTranslationEnabled +
                ", profileBackgroundColor='" + profileBackgroundColor + '\'' +
                ", profileBackgroundImageUrl='" + profileBackgroundImageUrl + '\'' +
                ", profileBackgroundImageUrlHttps='" + profileBackgroundImageUrlHttps + '\'' +
                ", profileBackgroundTile='" + profileBackgroundTile + '\'' +
                ", profileImageUrl='" + profileImageUrl + '\'' +
                ", profileImageUrlHttps='" + profileImageUrlHttps + '\'' +
                ", profileBannerUrl='" + profileBannerUrl + '\'' +
                ", profileLinkColor='" + profileLinkColor + '\'' +
                ", profileSidebarBorderColor='" + profileSidebarBorderColor + '\'' +
                ", profileSidebarFillColor='" + profileSidebarFillColor + '\'' +
                ", profileTextColor='" + profileTextColor + '\'' +
                ", profileUseBackgroundImage='" + profileUseBackgroundImage + '\'' +
                ", defaultProfileImage=" + defaultProfileImage +
                ", following='" + following + '\'' +
                ", followRequestSent=" + followRequestSent +
                ", notifications='" + notifications + '\'' +
                ", translatorType='" + translatorType + '\'' +
                ", defaultProfile=" + defaultProfile +
                '}';
    }

    public boolean isDefaultProfile() {
        return defaultProfile;
    }

    public void setDefaultProfile(boolean defaultProfile) {
        this.defaultProfile = defaultProfile;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean istProtected() {
        return tProtected;
    }

    public void settProtected(boolean tProtected) {
        this.tProtected = tProtected;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public int getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(int friendsCount) {
        this.friendsCount = friendsCount;
    }

    public int getListedCount() {
        return listedCount;
    }

    public void setListedCount(int listedCount) {
        this.listedCount = listedCount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(int favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    public String getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(String utcOffset) {
        this.utcOffset = utcOffset;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public boolean isGeoEnabled() {
        return geoEnabled;
    }

    public void setGeoEnabled(boolean geoEnabled) {
        this.geoEnabled = geoEnabled;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public int getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(int statusesCount) {
        this.statusesCount = statusesCount;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public boolean isContributorsEnabled() {
        return contributorsEnabled;
    }

    public void setContributorsEnabled(boolean contributorsEnabled) {
        this.contributorsEnabled = contributorsEnabled;
    }

    public boolean isTranslator() {
        return isTranslator;
    }

    public void setTranslator(boolean translator) {
        isTranslator = translator;
    }

    public boolean isTranslationEnabled() {
        return isTranslationEnabled;
    }

    public void setTranslationEnabled(boolean translationEnabled) {
        isTranslationEnabled = translationEnabled;
    }

    public String getProfileBackgroundColor() {
        return profileBackgroundColor;
    }

    public void setProfileBackgroundColor(String profileBackgroundColor) {
        this.profileBackgroundColor = profileBackgroundColor;
    }

    public String getProfileBackgroundImageUrl() {
        return profileBackgroundImageUrl;
    }

    public void setProfileBackgroundImageUrl(String profileBackgroundImageUrl) {
        this.profileBackgroundImageUrl = profileBackgroundImageUrl;
    }

    public String getProfileBackgroundImageUrlHttps() {
        return profileBackgroundImageUrlHttps;
    }

    public void setProfileBackgroundImageUrlHttps(String profileBackgroundImageUrlHttps) {
        this.profileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
    }

    public String getProfileBackgroundTile() {
        return profileBackgroundTile;
    }

    public void setProfileBackgroundTile(String profileBackgroundTile) {
        this.profileBackgroundTile = profileBackgroundTile;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getProfileImageUrlHttps() {
        return profileImageUrlHttps;
    }

    public void setProfileImageUrlHttps(String profileImageUrlHttps) {
        this.profileImageUrlHttps = profileImageUrlHttps;
    }

    public String getProfileBannerUrl() {
        return profileBannerUrl;
    }

    public void setProfileBannerUrl(String profileBannerUrl) {
        this.profileBannerUrl = profileBannerUrl;
    }

    public String getProfileLinkColor() {
        return profileLinkColor;
    }

    public void setProfileLinkColor(String profileLinkColor) {
        this.profileLinkColor = profileLinkColor;
    }

    public String getProfileSidebarBorderColor() {
        return profileSidebarBorderColor;
    }

    public void setProfileSidebarBorderColor(String profileSidebarBorderColor) {
        this.profileSidebarBorderColor = profileSidebarBorderColor;
    }

    public String getProfileSidebarFillColor() {
        return profileSidebarFillColor;
    }

    public void setProfileSidebarFillColor(String profileSidebarFillColor) {
        this.profileSidebarFillColor = profileSidebarFillColor;
    }

    public String getProfileTextColor() {
        return profileTextColor;
    }

    public void setProfileTextColor(String profileTextColor) {
        this.profileTextColor = profileTextColor;
    }

    public String getProfileUseBackgroundImage() {
        return profileUseBackgroundImage;
    }

    public void setProfileUseBackgroundImage(String profileUseBackgroundImage) {
        this.profileUseBackgroundImage = profileUseBackgroundImage;
    }

    public boolean isDefaultProfileImage() {
        return defaultProfileImage;
    }

    public void setDefaultProfileImage(boolean defaultProfileImage) {
        this.defaultProfileImage = defaultProfileImage;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public boolean isFollowRequestSent() {
        return followRequestSent;
    }

    public void setFollowRequestSent(boolean followRequestSent) {
        this.followRequestSent = followRequestSent;
    }

    public String getNotifications() {
        return notifications;
    }

    public void setNotifications(String notifications) {
        this.notifications = notifications;
    }

    public String getTranslatorType() {
        return translatorType;
    }

    public void setTranslatorType(String translatorType) {
        this.translatorType = translatorType;
    }
}
