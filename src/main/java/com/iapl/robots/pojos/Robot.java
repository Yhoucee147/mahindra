package com.iapl.robots.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Robot {

    @JsonProperty
    private String model;
    @JsonProperty
    private String serialNumber;
    @JsonProperty
    private String manufacturedDate;
    @JsonProperty
    private String category;

}
