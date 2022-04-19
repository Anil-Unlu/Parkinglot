package com.project.parkinglot.controller.vehicle;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum VehicleEnum {
    @JsonProperty("Sedan")
    SEDAN,
    @JsonProperty("Suv")
    SUV,
    @JsonProperty("Minivan")
    MINIVAN
}
