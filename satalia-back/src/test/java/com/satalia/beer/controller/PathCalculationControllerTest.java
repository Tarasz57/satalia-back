package com.satalia.beer.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.satalia.beer.dto.CalculatePathRequest;
import com.satalia.beer.dto.CalculatedPathResponse;
import com.satalia.beer.service.PathCalculationService;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class PathCalculationControllerTest {

  @Mock
  PathCalculationService pathCalculationService;
  @InjectMocks
  PathCalculationController pathCalculationController;

  @Test
  void pathCalculationEndpointReturnsHttpOk() {

    CalculatedPathResponse serviceResponse = new CalculatedPathResponse(Collections.emptyList(), Collections.emptyList(), 0d);
    CalculatePathRequest request = new CalculatePathRequest(2d, 2d, 2d);

    when(pathCalculationService.calculatePath(any())).thenReturn(serviceResponse);

    ResponseEntity response = pathCalculationController.calculatePath(request);

    assertEquals(HttpStatus.OK, response.getStatusCode());
  }

}
