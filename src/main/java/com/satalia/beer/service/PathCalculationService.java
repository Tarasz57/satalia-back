package com.satalia.beer.service;

import com.satalia.beer.dto.CalculatePathRequest;
import com.satalia.beer.dto.CalculatedPathResponse;
import org.springframework.stereotype.Service;

@Service
public class PathCalculationService {

    public CalculatedPathResponse calculatePath(CalculatePathRequest request) {

        return new CalculatedPathResponse();
    }

}
