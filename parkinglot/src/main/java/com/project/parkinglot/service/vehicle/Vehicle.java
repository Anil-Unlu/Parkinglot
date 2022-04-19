package com.project.parkinglot.service.vehicle;

import com.project.parkinglot.controller.vehicle.VehicleEnum;
import com.project.parkinglot.entity.vehicle.VehicleEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Vehicle {

    private long id;

    private String licensePlate;

    private VehicleEnum vehicleEnum;

    private long parkingAreaId;

    private LocalDateTime checkIn;

    private LocalDateTime checkOut;

    public VehicleEntity toEntity(){
        VehicleEntity vehicleEntity = new VehicleEntity();
        vehicleEntity.setVehicleEnum(vehicleEnum);
        vehicleEntity.setParkingAreaId(parkingAreaId);
        vehicleEntity.setCheckIn(checkIn);
        vehicleEntity.setLicensePlate(licensePlate);
        vehicleEntity.setCheckOut(checkOut);
        return vehicleEntity;
    }

    public static Vehicle toModel(VehicleEntity vehicleEntity){
        return Vehicle.builder()
                .id(vehicleEntity.getId())
                .checkOut(vehicleEntity.getCheckOut())
                .checkIn(vehicleEntity.getCheckIn())
                .vehicleEnum(vehicleEntity.getVehicleEnum())
                .licensePlate(vehicleEntity.getLicensePlate())
                .parkingAreaId(vehicleEntity.getParkingAreaId())
                .build();
    }

}
