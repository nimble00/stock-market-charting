package com.nimble00.stockmarketservice.services;

import com.nimble00.stockmarketservice.models.IPO;
import com.nimble00.stockmarketservice.shared.IpoDTO;

import java.util.List;

public interface IPOService {

    public IpoDTO addIPO(IpoDTO ipo);
    public List<IpoDTO> getAllIPO();

}
