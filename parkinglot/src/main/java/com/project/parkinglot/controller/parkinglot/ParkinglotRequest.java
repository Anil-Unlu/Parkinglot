package com.project.parkinglot.controller.parkinglot;

import com.project.parkinglot.service.parkinglot.Parkinglot;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ApiModel(value = "This is parkignlot request model")
public class ParkinglotRequest {

    @NotNull
    private long totalCapacity;

    @NotEmpty
    private String parkinglotName;

    @NotEmpty
    private String city;

    public Parkinglot toModel(){
        return Parkinglot.builder()
                .totalCapacity(totalCapacity)
                .currentCapacity(totalCapacity)
                .parkinglotName(parkinglotName)
                .city(city)
                .totalAmount(0)
                .build();
    }

}
