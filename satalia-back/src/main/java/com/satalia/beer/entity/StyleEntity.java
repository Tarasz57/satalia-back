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
@Table(name = "STYLE")
public class StyleEntity {

    @Id
    private Long id;
    private Long catId;
    private String styleName;
    private Date lastModified;

}
