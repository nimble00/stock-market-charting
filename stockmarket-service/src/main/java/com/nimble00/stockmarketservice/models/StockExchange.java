package com.nimble00.stockmarketservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class StockExchange {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "exchange_id")
    private Integer id;
    private String name;
    private String brief;
    private String contactAddress;
    private String remarks;
}
