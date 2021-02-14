package com.github.elijasp.saletracker.repositories;

import com.github.elijasp.saletracker.domain.Sale;
import org.springframework.data.repository.CrudRepository;

public interface SaleRepository extends CrudRepository<Sale, Long> {
}
