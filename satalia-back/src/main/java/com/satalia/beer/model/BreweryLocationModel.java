package com.satalia.beer.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class BreweryLocationModel {
    private String breweryName;
    @Id
    private Long breweryId;
    private Double longitude;
    private Double latitude;
    private Double distanceFromCurrentPos;
}
