package com.nimble00.stockmarketservice.repository;

import com.nimble00.stockmarketservice.models.Ticker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.stereotype.Repository;

@Repository
public interface TickerRepo extends JpaRepository<Ticker, Integer> {

}
