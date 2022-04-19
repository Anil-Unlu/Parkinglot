package com.project.parkinglot.repository.vehicle;

import com.project.parkinglot.entity.vehicle.MinivanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MinivanRepository extends JpaRepository< MinivanEntity, Long> {

}
