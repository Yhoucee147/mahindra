package com.iapl.robots.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iapl.robots.entities.Location;
import lombok.Data;

@Data
public class UpdateSurvivorLocationRequest {

    @JsonProperty
    private long survivorId;
    @JsonProperty
    private Location location;

}
