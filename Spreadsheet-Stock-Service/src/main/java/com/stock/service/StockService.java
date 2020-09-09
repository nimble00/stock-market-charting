package com.stock.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.stock.entity.StockPrice;

public interface StockService {
	
	public List<String> uploadStockData(MultipartFile file) throws Exception;
	public List<StockPrice> listALL();
	

}
