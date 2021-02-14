package com.github.elijasp.saletracker.services;

import com.github.elijasp.saletracker.domain.Sale;
import com.github.elijasp.saletracker.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
    // == fields ==
    private final SaleRepository saleRepository;

    // == constructor based DI ==
    @Autowired
    public SaleService(SaleRepository saleRepository){
        this.saleRepository = saleRepository;
    }

    public Sale save(Sale sale){
        return saleRepository.save(sale);
    }
}
