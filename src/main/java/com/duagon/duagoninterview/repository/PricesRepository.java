package com.duagon.duagoninterview.repository;

import com.duagon.duagoninterview.entity.Prices;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesRepository extends CrudRepository<Prices, Long> {
}
