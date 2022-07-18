package com.iapl.robots.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "resources")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private long resourceId;
    @Column
    @JsonProperty
    private String resouceName;
    @Column
    @JsonProperty
    private String description;

}
