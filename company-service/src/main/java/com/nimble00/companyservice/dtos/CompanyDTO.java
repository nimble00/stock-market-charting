package com.nimble00.companyservice.dtos;

import com.nimble00.companyservice.models.StockExchange;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class CompanyDTO {
    private String id;
    private String name;
    private Long turnover;
    private String ceo;
    private String boardOfDirs;
    private List<StockExchange> stockExchangeList;
    private String sector;
    private String briefWriteup;
    private String ticker;
}
