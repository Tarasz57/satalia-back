package com.satalia.beer.dto;

import com.satalia.beer.entity.BeerEntity;
import com.satalia.beer.entity.BreweryEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class CalculatedPathResponse {

    private List<String> breweriesVisited;
    private List<String> beersCollected;
    private Double distanceTraveled;

}
