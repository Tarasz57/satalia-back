package com.satalia.beer.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HaversineTest {

  @Test
  void haversineReturnsDouble() {
    Double result = Haversine.haversine( 2d, 2d, 2d, 2d);
    assertEquals(Double.class, result.getClass());
  }

  @Test
  void haversineReturnsExpectedValue() {
    Double result = Haversine.haversine( 2d, 2d, 4d, 4d);
    assertEquals(314.37204958932233, result);
  }

}
