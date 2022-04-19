package com.project.parkinglot.controller.parkinglot;

import com.project.parkinglot.service.parkinglot.Parkinglot;
import com.project.parkinglot.service.pricelist.PriceList;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ApiModel(value = "This is parkinglot response model")
public class ParkinglotResponse {

    private long id;
    private long totalCapacity;
    private long currentCapacity;
    private String parkinglotName;
    private String city;
    private PriceList priceList;
    private double totalAmount;

    public static ParkinglotResponse toResponse(Parkinglot parkinglot){
        return ParkinglotResponse.builder()
                .id(parkinglot.getId())
                .parkinglotName(parkinglot.getParkinglotName())
                .totalCapacity(parkinglot.getTotalCapacity())
                .currentCapacity(parkinglot.getCurrentCapacity())
                .city(parkinglot.getCity())
                .priceList(parkinglot.getPriceList())
                .totalAmount(parkinglot.getTotalAmount())
                .build();
    }
}
