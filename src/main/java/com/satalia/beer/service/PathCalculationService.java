package com.satalia.beer.service;

import com.satalia.beer.dto.CalculatePathRequest;
import com.satalia.beer.dto.CalculatedPathResponse;
import com.satalia.beer.model.BreweryLocationModel;
import com.satalia.beer.repository.BeerRepository;
import com.satalia.beer.repository.BreweryLocationRepository;
import com.satalia.beer.repository.BreweryRepository;
import com.satalia.beer.utils.Haversine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class PathCalculationService {

    private BeerRepository beerRepository;
    private BreweryRepository breweryRepository;
    private BreweryLocationRepository breweryLocationRepository;

    @Autowired
    public PathCalculationService(BeerRepository beerRepository, BreweryRepository breweryRepository, BreweryLocationRepository breweryLocationRepository) {
        this.beerRepository = beerRepository;
        this.breweryRepository = breweryRepository;
        this.breweryLocationRepository = breweryLocationRepository;
    }

    public CalculatedPathResponse calculatePath(CalculatePathRequest request) {
        List<String> visitedBreweries = new ArrayList<>();
        List<String> beersCollected = new ArrayList<>();
        Double distanceTravelled = 0D;
        Double fuelLeft = request.getDistanceAvailable();
        Double startingLat = request.getLatStart();
        Double startingLon = request.getLonStart();
        Double currentLat;
        Double currentLon;
        List<BreweryLocationModel> locationInfo = breweryLocationRepository.findAllById();
        calculateDistance(startingLat, startingLon, locationInfo);


        while(fuelLeft >= locationInfo.get(0).getDistanceFromCurrentPos() + Haversine.haversine(locationInfo.get(0).getLatitude(), locationInfo.get(0).getLongitude(), startingLat, startingLon)) {
            BreweryLocationModel currentBrewery = locationInfo.get(0);
            visitedBreweries.add(currentBrewery.getBreweryName());
            distanceTravelled += currentBrewery.getDistanceFromCurrentPos();
            beersCollected.addAll(beerRepository.findAllByBreweryId(currentBrewery.getBreweryId()));
            fuelLeft -= currentBrewery.getDistanceFromCurrentPos();
            currentLon = currentBrewery.getLongitude();
            currentLat = currentBrewery.getLatitude();

            locationInfo.remove(0);
            calculateDistance(currentLat, currentLon, locationInfo);
        }
        distanceTravelled += Haversine.haversine(locationInfo.get(0).getLatitude(), locationInfo.get(0).getLongitude(), startingLat, startingLon);


        return new CalculatedPathResponse(visitedBreweries, beersCollected, distanceTravelled);
    }

    private void calculateDistance(Double latitude, Double longitude, List<BreweryLocationModel> locationInfo) {
        for (BreweryLocationModel locationModel: locationInfo) {
            locationModel.setDistanceFromCurrentPos(Haversine.haversine(latitude, longitude, locationModel.getLatitude(), locationModel.getLongitude()));
        }
        locationInfo.sort(Comparator.comparingDouble(BreweryLocationModel::getDistanceFromCurrentPos));
    }

}
