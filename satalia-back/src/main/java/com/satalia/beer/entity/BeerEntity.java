package com.satalia.beer.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "BEER")
public class BeerEntity {

  @Id
  private Long id;
  private Long breweryId;
  private String name;
  private Long catId;
  private Long styleId;
  private Double abv;
  private Double ibu;
  private Double srm;
  private Long upc;
  private String filepath;
  @Column(length = 32767)
  private String description;
  private Integer addUser;
  private Date lastModified;

}
