package com.project.parkinglot.service;

import com.project.parkinglot.controller.vehicle.VehicleEnum;
import com.project.parkinglot.service.exception.DataNotFoundException;
import com.project.parkinglot.service.exception.ExceptionType;
import com.project.parkinglot.service.vehicle.VehicleService;
import com.project.parkinglot.service.vehicle.minivan.MinivanVehicleService;
import com.project.parkinglot.service.vehicle.sedan.SedanVehicleService;
import com.project.parkinglot.service.vehicle.suv.SuvVehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VehicleFactoryService {

    public final MinivanVehicleService minivanVehicleService;

    public final SuvVehicleService suvVehicleService;

    public final SedanVehicleService sedanVehicleService;

    public VehicleService getServiceType(VehicleEnum vehicleEnum){
        if(vehicleEnum == VehicleEnum.SEDAN){
            return sedanVehicleService;
        }else if(vehicleEnum == VehicleEnum.MINIVAN){
            return minivanVehicleService;
        }else if(vehicleEnum == VehicleEnum.SUV){
            return suvVehicleService;
        }
        else{
            throw new DataNotFoundException(ExceptionType.VEHICLE_TYPE_INCORRECT);
        }
    }

}
