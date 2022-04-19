package com.project.parkinglot.entity.parkinglot;

import com.project.parkinglot.entity.pricelist.PriceListEntity;
import com.project.parkinglot.service.parkinglot.Parkinglot;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "parkinglot")
@Table(name = "parkinglot")
@Getter
@Setter
public class ParkinglotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = true)
    private String parkinglotName;

    @Column(nullable = false)
    private long totalCapacity;

    @Column(nullable = false)
    private long currentCapacity;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private double totalAmount;

    @ManyToOne()
    @JoinColumn(nullable = false)
    private PriceListEntity priceListEntity;

    public Parkinglot fromEntity(){
        return Parkinglot.builder()
                .city(city)
                .id(id)
                .totalCapacity(totalCapacity)
                .parkinglotName(parkinglotName)
                .priceList(PriceListEntity.fromEntityStatic(priceListEntity))
                .totalAmount(totalAmount)
                .currentCapacity(currentCapacity)
                .build();
    }

}