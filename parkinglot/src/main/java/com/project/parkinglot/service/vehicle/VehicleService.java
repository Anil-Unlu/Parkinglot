package com.project.parkinglot.service.vehicle;


/**
 * Calculations will be placed on each vehicle type
 */
public interface VehicleService {

	void checkIn(Vehicle vehicle);
	Vehicle getVehicle(String id);
	void checkOut(CheckOutModel checkOutModel);
}
