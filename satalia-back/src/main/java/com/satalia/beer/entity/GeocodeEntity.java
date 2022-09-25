package com.satalia.beer.entity;

import com.satalia.beer.enums.Accuracy;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "GEOCODE")
public class GeocodeEntity {

  @Id
  private Long id;
  private Long breweryId;
  private Double latitude;
  private Double longitude;
  @Column(columnDefinition="varchar(40)")
  private Accuracy accuracy;

}
