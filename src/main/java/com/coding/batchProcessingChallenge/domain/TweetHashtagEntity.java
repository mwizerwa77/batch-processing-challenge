package com.coding.batchProcessingChallenge.domain;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class TweetHashtagEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String text;

    @ElementCollection(targetClass=Integer.class)
    private List<Integer> indices;

    @Override
    public String toString() {
        return "TweetHashtagEntity{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", indices=" + indices +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Integer> getIndices() {
        return indices;
    }

    public void setIndices(List<Integer> indices) {
        this.indices = indices;
    }
}
