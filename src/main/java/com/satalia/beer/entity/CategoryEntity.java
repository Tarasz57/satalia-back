package com.satalia.beer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "CATEGORY")
public class CategoryEntity {

    @Id
    private Long id;
    private String cat_name;
    private Date lastModified;

}
