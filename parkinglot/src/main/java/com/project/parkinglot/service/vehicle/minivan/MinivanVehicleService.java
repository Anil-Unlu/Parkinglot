package com.project.parkinglot.service.vehicle.minivan;

import com.project.parkinglot.service.exception.DataNotFoundException;
import com.project.parkinglot.service.exception.ExceptionType;
import com.project.parkinglot.service.parkinglot.Parkinglot;
import com.project.parkinglot.service.parkinglot.ParkinglotService;
import com.project.parkinglot.entity.vehicle.VehicleEntity;
import com.project.parkinglot.repository.vehicle.VehicleRepository;
import com.project.parkinglot.service.pricelist.PriceList;
import com.project.parkinglot.service.vehicle.CheckOutModel;
import com.project.parkinglot.service.vehicle.Vehicle;
import com.project.parkinglot.service.vehicle.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MinivanVehicleService implements VehicleService {

    private final VehicleRepository minivanRepository;
    private final ParkinglotService parkinglotService;


    public void checkIn(Vehicle vehicle) {
        Boolean existedVehicle = minivanRepository.existsByLicensePlate(vehicle.getLicensePlate());
        if(existedVehicle)
            throw new DataNotFoundException(ExceptionType.LICENSEPLATEALREADYEXIST);
        Parkinglot parkinglot = parkinglotService.getParkinglot(vehicle.getParkingAreaId());
        if(parkinglot.getCurrentCapacity() < 1)
            throw new DataNotFoundException(ExceptionType.CAPACITY_OVER_FLOW);
        parkinglot.setCurrentCapacity(parkinglot.getCurrentCapacity()-1);
        parkinglotService.updateParkinglot( parkinglot, parkinglot.getId());
        VehicleEntity vehicleEntity = vehicle.toEntity();
        minivanRepository.save(vehicleEntity);
    }

    public Vehicle getVehicle(String id) {
        return Vehicle.toModel(minivanRepository.findByLicensePlate(id)
                .orElseThrow(()-> new DataNotFoundException(ExceptionType.LICENSEPLATE_NOT_FOUND)));
    }

    public void checkOut( CheckOutModel checkOutModel) {
        Vehicle vehicleExisted = Vehicle.toModel(minivanRepository.findByLicensePlate(checkOutModel.getLicensePlate())
                .orElseThrow(()-> new DataNotFoundException(ExceptionType.LICENSEPLATE_NOT_FOUND)));
        Parkinglot parkinglot = parkinglotService.getParkinglot(vehicleExisted.getParkingAreaId());
        if(checkOutModel.getHoursToStayed() <= 0)
            throw new DataNotFoundException(ExceptionType.HOURS_TO_STAY);
        PriceList priceList = parkinglot.getPriceList();
        if(checkOutModel.getHoursToStayed()<3)
            parkinglot.setTotalAmount(parkinglot.getTotalAmount()+priceList.getFirstTwoHour());
        else if(checkOutModel.getHoursToStayed()>=3 && checkOutModel.getHoursToStayed()<5)
            parkinglot.setTotalAmount(parkinglot.getTotalAmount()+priceList.getTwoHourToFourHour()*1.15);
        else if(checkOutModel.getHoursToStayed()>=5 && checkOutModel.getHoursToStayed()<9)
            parkinglot.setTotalAmount(parkinglot.getTotalAmount()+priceList.getFourHourToEightHour()*1.15);
        else if(checkOutModel.getHoursToStayed()>=9 && checkOutModel.getHoursToStayed()<15)
            parkinglot.setTotalAmount(parkinglot.getTotalAmount()+priceList.getEightHourToFourTeenHour()*1.15);
        else if(checkOutModel.getHoursToStayed()>=15 && checkOutModel.getHoursToStayed()<=24)
            parkinglot.setTotalAmount(parkinglot.getTotalAmount()+priceList.getFourTeenHourToTwenyFourHour()*1.15);
        parkinglot.setCurrentCapacity(parkinglot.getCurrentCapacity()+1);
        parkinglotService.updateParkinglot( parkinglot, parkinglot.getId());
        minivanRepository.deleteById(vehicleExisted.getId());
    }
}
