package com.nimble00.companyservice.dao;

import com.nimble00.companyservice.models.IPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPORepo extends JpaRepository<IPO,String> {

}
