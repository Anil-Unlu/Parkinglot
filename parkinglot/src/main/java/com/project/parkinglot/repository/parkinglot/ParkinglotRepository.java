package com.project.parkinglot.repository.parkinglot;

import com.project.parkinglot.entity.parkinglot.ParkinglotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkinglotRepository extends JpaRepository< ParkinglotEntity, Long> {
}
