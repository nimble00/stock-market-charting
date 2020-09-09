package com.stock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.entity.CompanyCode;

@Repository
public interface CompanyCodeDAO extends JpaRepository<CompanyCode,Integer>{

	public CompanyCode findByValue(String value);
}
