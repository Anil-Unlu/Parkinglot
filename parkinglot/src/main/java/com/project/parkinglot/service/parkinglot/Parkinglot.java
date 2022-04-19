package com.project.parkinglot.service.parkinglot;

import com.project.parkinglot.entity.parkinglot.ParkinglotEntity;
import com.project.parkinglot.service.pricelist.PriceList;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Parkinglot {

    private long id;

    private long totalCapacity;

    private long currentCapacity;

    private String parkinglotName;

    private String city;

    private PriceList priceList;

    private double totalAmount;

    public ParkinglotEntity toEntity(){
        ParkinglotEntity parkinglotEntity = new ParkinglotEntity();
        parkinglotEntity.setParkinglotName(parkinglotName);
        parkinglotEntity.setTotalCapacity(totalCapacity);
        parkinglotEntity.setCity(city);
        parkinglotEntity.setCurrentCapacity(currentCapacity);
        parkinglotEntity.setTotalAmount(totalAmount);
        return parkinglotEntity;
    }

}
