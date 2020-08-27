package com.nimble00.stockmarketservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import com.nimble00.stockmarketservice.models.StockExchange;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@DynamicUpdate
@Entity
public class Company {
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "company_id")
    private String id;
    private String name;
    private Long turnover;
    private String ceo;
    private String boardOfDirs;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "company_exchange", joinColumns = {@JoinColumn(name = "company_id") },
            inverseJoinColumns = {@JoinColumn(name = "exchange_id") })
    private List<StockExchange> stockExchangeList;
    private String sector;
    private String briefWriteup;
    @ElementCollection
    private List<String> tickerList;
}