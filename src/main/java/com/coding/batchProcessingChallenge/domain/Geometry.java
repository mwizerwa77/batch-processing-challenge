package com.coding.batchProcessingChallenge.domain;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class Geometry implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    private Long id;

    private String type;

    @ElementCollection(targetClass=Double.class)
    private List<Double> coordinates;

    @Override
    public String toString() {
        return "Geometry{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
