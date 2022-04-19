package com.project.parkinglot.controller.vehicle;

import com.project.parkinglot.service.vehicle.Vehicle;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@ApiModel(value = "This is vehicle request model")
public class VehicleRequest {

    @NotBlank
    private String licensePlate;

    @NotEmpty
    private VehicleEnum vehicleEnum;

    @NotNull
    private long parkingAreaId;

    private LocalDateTime checkIn;

    private LocalDateTime checkOut;

    public Vehicle toModel(){
        return Vehicle.builder()
                .licensePlate(licensePlate)
                .vehicleEnum(vehicleEnum)
                .checkIn(LocalDateTime.now())
                .parkingAreaId(parkingAreaId)
                .checkOut(LocalDateTime.now())
                .build();
    }


}
