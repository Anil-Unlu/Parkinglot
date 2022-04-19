package com.project.parkinglot.repository.vehicle;

import com.project.parkinglot.entity.vehicle.SedanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SedanRepository extends JpaRepository<SedanEntity, Long> {
}
