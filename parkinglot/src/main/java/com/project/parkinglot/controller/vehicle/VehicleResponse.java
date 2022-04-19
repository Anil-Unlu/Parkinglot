package com.project.parkinglot.controller.vehicle;

import com.project.parkinglot.service.vehicle.Vehicle;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@ApiModel(value = "This is vehicle response model")
public class VehicleResponse {

    private String licensePlate;

    private VehicleEnum vehicleEnum;

    private long parkingAreaId;

    private LocalDateTime checkIn;

    private LocalDateTime checkOut;

    public static VehicleResponse toResponse(Vehicle vehicle){
        return VehicleResponse.builder()
                .licensePlate(vehicle.getLicensePlate())
                .vehicleEnum(vehicle.getVehicleEnum())
                .checkIn(vehicle.getCheckIn())
                .checkOut(vehicle.getCheckOut())
                .parkingAreaId(vehicle.getParkingAreaId())
                .build();
    }
}
