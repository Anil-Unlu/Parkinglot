package com.project.parkinglot.controller.parkinglot;

import com.project.parkinglot.service.parkinglot.Parkinglot;
import com.project.parkinglot.service.parkinglot.ParkinglotService;
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
@Api(value = "This is a rest controller for parkinglots")
public class ParkinglotController {

    //Parkinglot crud operations

    private final ParkinglotService parkinglotService;

    @ApiOperation(value = "add a new parkinglot")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Scuccesfully created parkinglot")})
    @PostMapping("/parkinglots")
    @ResponseStatus(HttpStatus.CREATED)
    public ParkinglotResponse create(@RequestBody @Valid ParkinglotRequest parkinglotRequest){
        Parkinglot parkinglot = parkinglotRequest.toModel();
        return ParkinglotResponse.toResponse(parkinglotService.create(parkinglot));
    }

    @ApiOperation(value = "retrieve parkignlot", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Succesfully retrieved parkinglot"),
        @ApiResponse(code = 404, message = "The resource you are trying to reach is not found")
    })
    @GetMapping("/parkinglots/{id}")
    public ResponseEntity<Optional<ParkinglotResponse>> getParkinglot(@PathVariable long id){
        return new ResponseEntity(ParkinglotResponse.toResponse(parkinglotService.getParkinglot(id)),HttpStatus.OK);
    }

    @ApiOperation(value = "update parkinglot", response = Iterable.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Succesfully updated parkinglot"),
        @ApiResponse(code = 404, message = "The resource you are trying to reach is not found")
    })
    @PutMapping("/parkinglots/{id}")
    public ResponseEntity<Optional<ParkinglotResponse>> updateParkinglot(@RequestBody @Valid ParkinglotRequest parkinglotRequest,@PathVariable long id){
        Parkinglot parkinglot = parkinglotRequest.toModel();
        return new ResponseEntity(ParkinglotResponse.toResponse(parkinglotService.updateParkinglot( parkinglot, id)), HttpStatus.OK);
    }

    @ApiOperation(value = "delete parkinglot")
    @ApiResponse(code = 204, message = "Scuccesfully deleted parkinglot")
    @DeleteMapping("/parkinglots/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeParkinglot(@PathVariable long id){
        parkinglotService.removeParkinglot(id);
    }

}
