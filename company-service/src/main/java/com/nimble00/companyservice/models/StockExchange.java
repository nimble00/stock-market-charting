package com.nimble00.companyservice.models;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@DynamicUpdate
public class StockExchange {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "stockexchange_id")
    private String id;
    private String name;
    private String brief;
    private String contactAddress;
    private String remarks;
}
