package com.nimble00.stockmarketservice.controllers;

import com.nimble00.stockmarketservice.services.IPOService;
import com.nimble00.stockmarketservice.shared.IpoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ipo")
public class IpoController {

    private IPOService ipoService;

    public IpoController(IPOService ipoService) {
        this.ipoService = ipoService;
    }

    public IpoController() {
    }

    @GetMapping("/test")
    public String test() {
        return "ipo-service is working";
    }

    @PostMapping("/add")
    public ResponseEntity<IpoDTO> createIPO(@RequestBody IpoDTO ipoDTO) {
        IpoDTO ipoDTO1 = ipoService.addIPO(ipoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ipoDTO1);
    }

    @GetMapping("/all")
    public ResponseEntity<List<IpoDTO>> getAllIPOs() {
        List<IpoDTO> list = ipoService.getAllIPO();
        return ResponseEntity.status(HttpStatus.FOUND).body(list);
    }
}
