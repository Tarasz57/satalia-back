package com.satalia.beer.repository;

import com.satalia.beer.entity.BeerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BeerRepository extends CrudRepository<BeerEntity, Long> {
    @Query(value = "SELECT name from beer where brewery_id = ?1", nativeQuery = true)
    List<String> findAllByBreweryId(Long breweryId);
}
