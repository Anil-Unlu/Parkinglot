package com.project.parkinglot.entity.pricelist;

import com.project.parkinglot.entity.parkinglot.ParkinglotEntity;
import com.project.parkinglot.service.pricelist.PriceList;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "price")
@Table(name = "price")
public class PriceListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = true)
    private Double firstTwoHour;

    @Column(nullable = false)
    private Double twoHourToFourHour;

    @Column(nullable = false)
    private Double fourHourToEightHour;

    @Column(nullable = false)
    private Double eightHourToFourTeenHour;

    @Column(nullable = false)
    private Double fourTeenHourToTwenyFourHour;

    @OneToMany(mappedBy = "priceListEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ParkinglotEntity> parkinglotEntities;

    public PriceList fromEntity(){
        return PriceList.builder()
                .id(id)
                .firstTwoHour(firstTwoHour)
                .twoHourToFourHour(twoHourToFourHour)
                .fourHourToEightHour(fourHourToEightHour)
                .eightHourToFourTeenHour(eightHourToFourTeenHour)
                .fourTeenHourToTwenyFourHour(fourTeenHourToTwenyFourHour)
                .build();
    }

    public static PriceList fromEntityStatic(PriceListEntity priceListEntity){
        return PriceList.builder()
                .id(priceListEntity.getId())
                .firstTwoHour(priceListEntity.getFirstTwoHour())
                .twoHourToFourHour(priceListEntity.getTwoHourToFourHour())
                .fourHourToEightHour(priceListEntity.getFourHourToEightHour())
                .eightHourToFourTeenHour(priceListEntity.getEightHourToFourTeenHour())
                .fourTeenHourToTwenyFourHour(priceListEntity.getFourTeenHourToTwenyFourHour())
                .build();
    }


}
