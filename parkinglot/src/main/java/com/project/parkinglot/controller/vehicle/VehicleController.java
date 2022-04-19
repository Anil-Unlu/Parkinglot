package com.project.parkinglot.controller.vehicle;

import com.project.parkinglot.service.VehicleFactoryService;
import com.project.parkinglot.service.vehicle.Vehicle;
import com.project.parkinglot.service.vehicle.VehicleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Api(value = "This is a rest controller for vehicles")
public class VehicleController {

    //Vehicle crud operations

    private final VehicleFactoryService vehicleFactoryService;

    @ApiOperation(value = "add a new vehicle")
    @ApiResponse(code = 201, message = "Succesfully created vehicle")
    @PostMapping("/vehicles")
    @ResponseStatus(HttpStatus.CREATED)
    public void createVehcile(@RequestBody @Valid VehicleRequest vehicleRequest){
        VehicleService vehicleService = vehicleFactoryService.getServiceType(vehicleRequest.getVehicleEnum());
        Vehicle vehicle = vehicleRequest.toModel();
        vehicleService.checkIn(vehicle);
    }

    @ApiOperation(value = "retrieve vehicle information", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Succesfully retrieved vehicle"),
            @ApiResponse(code = 404, message = "The resource you are trying to reach is not found")
    })
    @GetMapping("/vehicles")
    public ResponseEntity<Optional<VehicleResponse>> getVehicle(@RequestBody VehicleRetrieveRequest vehicleRetrieveRequest) {

        VehicleService vehicleService  = vehicleFactoryService.getServiceType(vehicleRetrieveRequest.getVehicleEnum());
        Vehicle vehicle = vehicleService.getVehicle(vehicleRetrieveRequest.getLicensePlate());
        return new ResponseEntity(VehicleResponse.toResponse(vehicle),HttpStatus.OK);
    }

    @ApiOperation(value = "checkout vehicle")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Succesfully checkedout"),
            @ApiResponse(code = 404, message = "The resource you are trying to reach is not found")
    })
    @PostMapping("/vehicles/checkouts")
    public ResponseEntity<String> checkOut(@RequestBody CheckOutRequest checkOutRequest){
        VehicleService vehicleService = vehicleFactoryService.getServiceType(checkOutRequest.getVehicleEnum());
        vehicleService.checkOut(checkOutRequest.toModel());
        return new ResponseEntity( "Vehicle checked out.", HttpStatus.OK);

    }

}
