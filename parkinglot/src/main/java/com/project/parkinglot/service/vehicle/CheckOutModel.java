package com.project.parkinglot.service.vehicle;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CheckOutModel {

    private String licensePlate;

    private long hoursToStayed;


}
