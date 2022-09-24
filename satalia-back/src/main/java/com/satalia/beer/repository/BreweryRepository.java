package com.satalia.beer.repository;

import com.satalia.beer.entity.BreweryEntity;
import org.springframework.data.repository.CrudRepository;

public interface BreweryRepository extends CrudRepository<BreweryEntity, Long> {
}
