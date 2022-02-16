package com.coding.batchProcessingChallenge.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class UrlEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    @JsonProperty("expanded_url")
    private String expandedUrl;

    @JsonProperty("display_url")
    private String displayUrl;

    @ElementCollection(targetClass=Integer.class)
    private List<Integer> indices;

    @Override
    public String toString() {
        return "UrlEntity{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", expandedUrl='" + expandedUrl + '\'' +
                ", displayUrl='" + displayUrl + '\'' +
                ", indices=" + indices +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExpandedUrl() {
        return expandedUrl;
    }

    public void setExpandedUrl(String expandedUrl) {
        this.expandedUrl = expandedUrl;
    }

    public String getDisplayUrl() {
        return displayUrl;
    }

    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl;
    }

    public List<Integer> getIndices() {
        return indices;
    }

    public void setIndices(List<Integer> indices) {
        this.indices = indices;
    }
}
