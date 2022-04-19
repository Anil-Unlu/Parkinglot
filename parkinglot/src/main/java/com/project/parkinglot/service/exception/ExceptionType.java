package com.project.parkinglot.service.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionType {

    PARKINGLOT_NOT_FOUND(1001,"Parkinglot cannot found"),
    LICENSEPLATE_NOT_FOUND(1002, "LicensePlate cannot found"),
    CAPACITY_OVER_FLOW(1003,"There is not enough capacity"),
    LICENSEPLATEALREADYEXIST(1004,"LicensePlate already exists"),
    HOURS_TO_STAY(1005,"You cannot enter 0 or negative number for hour"),
    VEHICLE_TYPE_INCORRECT(1006,"Vehicle type must be Sedan,Suv or Minivan"),
    GENERIC_EXCEPTION(1,"An error occured");


    private final Integer code;
    private final String message;


}
