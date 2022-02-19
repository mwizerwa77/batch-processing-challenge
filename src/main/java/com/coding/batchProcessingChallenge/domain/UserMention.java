package com.coding.batchProcessingChallenge.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class UserMention implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    private Long id;

    private String name;

    @ElementCollection(targetClass=Integer.class)
    private List<Integer> indices;

    @JsonProperty("screen_name")
    private String screenName;

    @JsonProperty("id_str")
    private String idStr;

    @Override
    public String toString() {
        return "UserMention{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", indices=" + indices +
                ", screenName='" + screenName + '\'' +
                ", idStr='" + idStr + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getIndices() {
        return indices;
    }

    public void setIndices(List<Integer> indices) {
        this.indices = indices;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
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
}
