package com.nimble00.uploadservice.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
//import java.util.Date;

@Entity
@Data
public class StockPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String ticker;
    private String stockExchange;
    private Double price;
    private Date changeDate;
    private Date timestamp;

}
