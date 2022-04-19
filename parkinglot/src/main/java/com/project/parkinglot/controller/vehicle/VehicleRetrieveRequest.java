package com.project.parkinglot.controller.vehicle;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ApiModel(value = "This is vehicle retrieve request model")
public class VehicleRetrieveRequest {

    @NotEmpty
    private String licensePlate;

    @NotEmpty
    private VehicleEnum vehicleEnum;

}
