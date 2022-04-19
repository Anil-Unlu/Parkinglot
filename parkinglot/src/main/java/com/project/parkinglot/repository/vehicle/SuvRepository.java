package com.project.parkinglot.repository.vehicle;

import com.project.parkinglot.entity.vehicle.SUVEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuvRepository extends JpaRepository< SUVEntity, Long> {
}
