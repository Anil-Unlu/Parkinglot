package com.project.parkinglot.service.parkinglot;

import com.project.parkinglot.entity.parkinglot.ParkinglotEntity;
import com.project.parkinglot.entity.pricelist.PriceListEntity;
import com.project.parkinglot.repository.parkinglot.ParkinglotRepository;
import com.project.parkinglot.service.exception.DataNotFoundException;
import com.project.parkinglot.service.exception.ExceptionType;
import com.project.parkinglot.service.pricelist.PriceList;
import com.project.parkinglot.service.pricelist.PriceListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParkinglotServiceImpl implements ParkinglotService{

    private final ParkinglotRepository parkinglotRepository;
    private final PriceListService priceListService;

    public Parkinglot create(Parkinglot parkinglot){
        ParkinglotEntity parkinglotEntity = parkinglot.toEntity();
        PriceList priceList = priceListService.create(createPriceList());
        PriceListEntity priceListEntity = priceList.toEntity();
        parkinglotEntity.setPriceListEntity(priceListEntity);
        return parkinglotRepository.save(parkinglotEntity).fromEntity();
    }


    public Parkinglot getParkinglot(long id) {
        return parkinglotRepository.findById(id)
                .orElseThrow(()->new DataNotFoundException(ExceptionType.PARKINGLOT_NOT_FOUND)).fromEntity();
    }


    public Parkinglot updateParkinglot(Parkinglot parkinglot, long id) {
        ParkinglotEntity existedParkinglotEntity = parkinglotRepository.findById(id)
                .orElseThrow(()->new DataNotFoundException(ExceptionType.PARKINGLOT_NOT_FOUND));
        ParkinglotEntity parkinglotEntity = parkinglot.toEntity();
        existedParkinglotEntity.setParkinglotName(parkinglotEntity.getParkinglotName());
        existedParkinglotEntity.setTotalCapacity(parkinglotEntity.getTotalCapacity());
        existedParkinglotEntity.setCity(parkinglotEntity.getCity());
        existedParkinglotEntity.setCurrentCapacity(parkinglotEntity.getCurrentCapacity());
        existedParkinglotEntity.setTotalAmount(parkinglotEntity.getTotalAmount());
        parkinglotRepository.save(existedParkinglotEntity);
        return existedParkinglotEntity.fromEntity();
    }


    public void removeParkinglot(long id) {
        parkinglotRepository.deleteById(id);
    }

    //Function generates random pricelist at the same time creating parkinglot
    public PriceList createPriceList(){
        PriceList priceList = new PriceList();
        double min = 10;
        double max = 20;
        Double baseLimit = (Math.random()*(max - min) + min);
        priceList.setFirstTwoHour(baseLimit);
        Double temp = (Math.random()*2+1);
        baseLimit += temp;
        priceList.setTwoHourToFourHour(baseLimit);
        temp = (Math.random()*2+1);
        baseLimit += temp;
        priceList.setFourHourToEightHour(baseLimit);
        temp = (Math.random()*2+1);
        baseLimit += temp;
        priceList.setEightHourToFourTeenHour(baseLimit);
        temp = (Math.random()*2+1);
        baseLimit += temp;
        priceList.setFourTeenHourToTwenyFourHour(baseLimit);
        return priceList;
    }

}
