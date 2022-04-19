package com.project.parkinglot;

import com.project.parkinglot.controller.parkinglot.ParkinglotRequest;
import com.project.parkinglot.controller.parkinglot.ParkinglotResponse;
import com.project.parkinglot.controller.vehicle.VehicleEnum;
import com.project.parkinglot.controller.vehicle.VehicleRequest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VehicleControllerTest extends BaseIntegrationTest{

    @Test
    void should_create_vehicle(){

        //Given
        VehicleRequest vehicleRequest = new VehicleRequest();
        vehicleRequest.setVehicleEnum(VehicleEnum.SEDAN);
        vehicleRequest.setLicensePlate("2Ca24eg");
        vehicleRequest.setParkingAreaId(1);

        ParkinglotRequest parkinglotRequest = new ParkinglotRequest();
        parkinglotRequest.setParkinglotName("parkinglotName");
        parkinglotRequest.setCity("city");
        parkinglotRequest.setTotalCapacity(4);

        //When
        ResponseEntity<ParkinglotResponse> response = testRestTemplate.postForEntity("/parkinglots", parkinglotRequest, ParkinglotResponse.class);
        ResponseEntity resultResponse = testRestTemplate.postForEntity("/vehicles", vehicleRequest, null);

        //Then
        assertThat(resultResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);

    }

}
