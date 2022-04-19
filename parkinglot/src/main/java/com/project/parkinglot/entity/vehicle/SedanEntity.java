package com.project.parkinglot.entity.vehicle;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "sedan")
@Table(name = "sedan")
//TODO define inheritance
public class SedanEntity extends VehicleEntity {

    public static SedanEntity toEntity(VehicleEntity vehicleEntity){
        SedanEntity sedanEntity = new SedanEntity();
        sedanEntity.setCheckIn(vehicleEntity.getCheckIn());
        sedanEntity.setLicensePlate(vehicleEntity.getLicensePlate());
        sedanEntity.setCheckOut(vehicleEntity.getCheckOut());
        sedanEntity.setVehicleEnum(vehicleEntity.getVehicleEnum());
        return sedanEntity;
    }

}
