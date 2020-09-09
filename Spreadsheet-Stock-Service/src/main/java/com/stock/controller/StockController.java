package com.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.stock.entity.StockPrice;
import com.stock.service.StockService;

@RestController
@RequestMapping("/api/stock")
public class StockController {
	
	@Autowired
	StockService stockService;

	@PostMapping("/upload")
	public ResponseEntity<List<String>> uploadData(@RequestParam("file") MultipartFile file )throws Exception
	{
		return new ResponseEntity<List<String>>(stockService.uploadStockData(file),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("list-all")
	public ResponseEntity<List<StockPrice>> findAll()
	{
		return new ResponseEntity<List<StockPrice>>(stockService.listALL(),HttpStatus.OK);
	}
	
}
