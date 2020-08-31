package com.nimble00.uploadservice.repository;

import com.nimble00.uploadservice.models.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockPriceRepo extends JpaRepository<StockPrice,Integer> {
}
