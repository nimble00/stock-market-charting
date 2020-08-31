package com.nimble00.stockmarketservice.shared;

import com.nimble00.stockmarketservice.models.Company;
import lombok.Data;

import javax.persistence.*;

@Data
public class IpoDTO {

//    private Integer id;
    private String companyName;
    private String stockExchange;
    private String sharePrice;
    private Long numShares;
    private String dateTime;
    private String remarks;
}
