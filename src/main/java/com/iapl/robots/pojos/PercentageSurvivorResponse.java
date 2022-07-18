package com.iapl.robots.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PercentageSurvivorResponse {

    @JsonProperty
    private double percentage;

}
