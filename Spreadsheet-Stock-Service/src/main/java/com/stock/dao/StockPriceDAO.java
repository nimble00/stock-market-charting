package com.stock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.entity.StockPrice;

@Repository
public interface StockPriceDAO extends JpaRepository<StockPrice,Integer>{

}
