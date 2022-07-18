package com.iapl.robots.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private long locationId;
    @Column
    @JsonProperty
    private double longitude;
    @Column
    @JsonProperty
    private double latitude;

}
