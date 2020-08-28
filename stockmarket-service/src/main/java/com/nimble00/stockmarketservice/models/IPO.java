package com.nimble00.stockmarketservice.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
public class IPO {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ipo_id")
    private Integer id;
    private String companyName;
    private String stockExchange;
    private String price;
    private Long numOfShares;
    private String dateTime;
    private String remarks;
}
