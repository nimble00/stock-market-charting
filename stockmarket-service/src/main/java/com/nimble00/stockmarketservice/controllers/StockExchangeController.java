package com.nimble00.stockmarketservice.controllers;

import com.nimble00.stockmarketservice.shared.StockExchangeDTO;
import com.nimble00.stockmarketservice.services.StockExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stockExchange")
public class StockExchangeController {

    //    @Autowired
    private StockExchangeService stockExchangeService;

//    public StockExchangeController(StockExchangeService stockExchangeService) {
//        this.stockExchangeService = stockExchangeService;
//    }

    @Autowired
    public StockExchangeController(StockExchangeService stockExchangeService) {
        super();
        this.stockExchangeService = stockExchangeService;
    }

    public StockExchangeController() {
        
    }

    @GetMapping("/test")
    public String test() {
        return "stock exchange service is working";
    }

    @GetMapping("/all")
    public ResponseEntity<List> getAllStockExchanges() {
        List<StockExchangeDTO> list = stockExchangeService.findAllStockExchanges();
        return ResponseEntity.status(HttpStatus.FOUND).body(list);
    }

    @PostMapping("/addStockExchange")
    public ResponseEntity<StockExchangeDTO> addStockExchange(@RequestBody StockExchangeDTO stockExchangeDTO) {
        StockExchangeDTO stockExchangeDTO1 = stockExchangeService.createStockExchange(stockExchangeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(stockExchangeDTO1);
    }

    @GetMapping("/{name}")
    public ResponseEntity<StockExchangeDTO> getStockExchangeByName(@PathVariable String name) {
        StockExchangeDTO stockExchangeDTO = stockExchangeService.findStockExchangeByName(name);
        return ResponseEntity.status(HttpStatus.FOUND).body(stockExchangeDTO);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<StockExchangeDTO> getStockExchangeById(@PathVariable Integer id) {
        StockExchangeDTO stockExchangeDTO = stockExchangeService.findStockExchangeById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(stockExchangeDTO);
    }
}

// Test object for Postman

//{
//        "name": "NYSE",
//        "brief": "nothing much",
//        "contactAddress": "new york",
//        "remarks":"biggest"
//}