package com.project.parkinglot.repository.pricelist;

import com.project.parkinglot.entity.pricelist.PriceListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceListRepository extends JpaRepository<PriceListEntity, Long> {
}
