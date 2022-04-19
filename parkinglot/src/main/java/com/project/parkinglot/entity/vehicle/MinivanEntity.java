package com.project.parkinglot.entity.vehicle;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "minivan")
@Table(name = "minivan")
//TODO define inheritance
public class MinivanEntity extends VehicleEntity {

    public static MinivanEntity toEntity(VehicleEntity vehicleEntity){
        MinivanEntity minivanEntity = new MinivanEntity();
        minivanEntity.setCheckIn(vehicleEntity.getCheckIn());
        minivanEntity.setVehicleEnum(vehicleEntity.getVehicleEnum());
        minivanEntity.setLicensePlate(vehicleEntity.getLicensePlate());
        minivanEntity.setCheckOut(vehicleEntity.getCheckOut());
        return minivanEntity;
    }

}
