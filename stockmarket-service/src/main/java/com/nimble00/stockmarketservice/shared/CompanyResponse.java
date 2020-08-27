package com.nimble00.stockmarketservice.shared;

import com.nimble00.stockmarketservice.models.StockExchange;
import com.nimble00.stockmarketservice.models.Ticker;
import lombok.Data;

import java.util.List;

@Data
public class CompanyResponse {
    private String id;
    private String name;
    private Long turnover;
    private String ceo;
    private String boardOfDirs;
    private List<StockExchange> stockExchangeList;
    //    private String stockExList;
    private String sector;
    private String briefWriteup;
    //    private String tickList;
    private List<Ticker> tickerList;
}
