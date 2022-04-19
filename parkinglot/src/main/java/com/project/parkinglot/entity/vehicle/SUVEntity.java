package com.project.parkinglot.entity.vehicle;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "suv")
@Table(name = "suv")
//TODO define inheritance
public class SUVEntity extends VehicleEntity {

    public static SUVEntity toEntity(VehicleEntity vehicleEntity){
        SUVEntity suvEntity = new SUVEntity();
        suvEntity.setCheckIn(vehicleEntity.getCheckIn());
        suvEntity.setLicensePlate(vehicleEntity.getLicensePlate());
        suvEntity.setVehicleEnum(vehicleEntity.getVehicleEnum());
        suvEntity.setCheckOut(vehicleEntity.getCheckOut());
        return suvEntity;
    }

}
