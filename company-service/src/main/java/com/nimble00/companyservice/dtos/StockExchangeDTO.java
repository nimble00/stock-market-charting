package com.nimble00.companyservice.dtos;

import lombok.Data;

@Data
public class StockExchangeDTO {
    private String id;
    private String name;
    private String brief;
    private String contactAddress;
    private String remarks;
}
