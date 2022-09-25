package com.satalia.beer.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.satalia.beer.dto.CalculatePathRequest;
import com.satalia.beer.dto.CalculatedPathResponse;
import com.satalia.beer.model.BreweryLocationModel;
import com.satalia.beer.repository.BreweryLocationRepository;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PathCalculationServiceTest {

  @Mock
  private BreweryLocationRepository breweryLocationRepository;
  @InjectMocks
  private PathCalculationService pathCalculationService;

  @Test
  void calculatingPathReturnsOnlyHomeRecordsWithZeroDistance() {
    BreweryLocationModel model = new BreweryLocationModel();
    model.setDistanceFromCurrentPos(0d);
    model.setBreweryId(12l);
    model.setLatitude(2d);
    model.setLongitude(2d);

    List<BreweryLocationModel> models = Collections.singletonList(model);
    CalculatePathRequest request = new CalculatePathRequest(3d, 3d, 0);

    when(breweryLocationRepository.findAllById()).thenReturn(models);

    CalculatedPathResponse response = pathCalculationService.calculatePath(request);

    assertEquals(2, response.getBreweriesVisited().size());
  }

}
