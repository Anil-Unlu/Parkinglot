package com.project.parkinglot.controller.vehicle;

import com.project.parkinglot.service.vehicle.CheckOutModel;
import io.swagger.annotations.ApiModel;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@ApiModel(value = "This is checkout request model")
public class CheckOutRequest {

    @NotNull
    private Integer hoursToStayed;

    @NotEmpty
    private String licensePlate;

    @NotEmpty
    private VehicleEnum vehicleEnum;

    public CheckOutModel toModel(){
        return CheckOutModel.builder()
                .hoursToStayed(hoursToStayed)
                .licensePlate(licensePlate)
                .build();
    }

}
