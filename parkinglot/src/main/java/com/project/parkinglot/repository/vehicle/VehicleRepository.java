package com.project.parkinglot.repository.vehicle;

import com.project.parkinglot.entity.vehicle.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository< VehicleEntity, Long> {

   Optional<VehicleEntity> findByLicensePlate(String licensePlate);
   Boolean existsByLicensePlate(String licensePlate);
}
