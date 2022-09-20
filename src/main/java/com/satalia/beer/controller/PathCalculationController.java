package com.satalia.beer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PathCalculationController {

  @GetMapping("/calculate-path")
  public ResponseEntity calculatePath() {
    return new ResponseEntity(HttpStatus.OK);
  }

}
