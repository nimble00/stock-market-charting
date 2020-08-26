package com.nimble00.companyservice.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class IPO {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String companyName;
    private String stockExchange;
    private String price;
    private Long numOfShares;
    private String dateTime;
    private String remarks;
}
