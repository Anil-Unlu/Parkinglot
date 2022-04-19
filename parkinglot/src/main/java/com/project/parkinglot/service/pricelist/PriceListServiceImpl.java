package com.project.parkinglot.service.pricelist;

import com.project.parkinglot.entity.pricelist.PriceListEntity;
import com.project.parkinglot.repository.pricelist.PriceListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceListServiceImpl implements PriceListService {

    private final PriceListRepository priceListRepository;

    public PriceList create(PriceList priceList) {
        PriceListEntity priceListEntity = priceList.toEntity();
        return priceListRepository.save(priceListEntity).fromEntity();
    }
}
