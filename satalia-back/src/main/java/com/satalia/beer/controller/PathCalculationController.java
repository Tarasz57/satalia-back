package com.satalia.beer.controller;

import com.satalia.beer.dto.CalculatePathRequest;
import com.satalia.beer.dto.CalculatedPathResponse;
import com.satalia.beer.service.PathCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PathCalculationController {

  private final PathCalculationService pathCalculationService;

  @Autowired
  PathCalculationController(PathCalculationService pathCalculationService) {
    this.pathCalculationService = pathCalculationService;
  }

  @GetMapping("/calculate-path")
  public ResponseEntity<CalculatedPathResponse> calculatePath(@RequestBody CalculatePathRequest request) {
    return new ResponseEntity(pathCalculationService.calculatePath(request), HttpStatus.OK);
  }

}
