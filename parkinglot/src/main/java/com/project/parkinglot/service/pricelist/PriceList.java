package com.project.parkinglot.service.pricelist;

import com.project.parkinglot.entity.pricelist.PriceListEntity;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "This is pricelist model")
public class PriceList {

    private long id;

    private Double firstTwoHour;

    private Double twoHourToFourHour;

    private Double fourHourToEightHour;

    private Double eightHourToFourTeenHour;

    private Double fourTeenHourToTwenyFourHour;

    public PriceListEntity toEntity(){
        PriceListEntity priceListEntity = new PriceListEntity();
        priceListEntity.setId(id);
        priceListEntity.setFirstTwoHour(firstTwoHour);
        priceListEntity.setTwoHourToFourHour(twoHourToFourHour);
        priceListEntity.setFourHourToEightHour(fourHourToEightHour);
        priceListEntity.setEightHourToFourTeenHour(eightHourToFourTeenHour);
        priceListEntity.setFourTeenHourToTwenyFourHour(fourTeenHourToTwenyFourHour);
        return priceListEntity;
    }

}
