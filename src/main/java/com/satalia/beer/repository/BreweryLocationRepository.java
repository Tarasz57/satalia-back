package com.satalia.beer.repository;

import com.satalia.beer.model.BreweryLocationModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BreweryLocationRepository extends CrudRepository<BreweryLocationModel, Long> {

    @Query(value = "SELECT br.id brewery_id, br.name brewery_name, ge.longitude, ge.latitude, 0 distance_from_current_pos from brewery br, geocode ge where ge.brewery_id = br.id", nativeQuery = true)
    List<BreweryLocationModel> findAllById();

}
