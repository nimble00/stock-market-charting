package com.nimble00.stockmarketservice.repository;

import com.nimble00.stockmarketservice.models.IPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPORepo extends JpaRepository<IPO,Integer> {

}
