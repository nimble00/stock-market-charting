package com.nimble00.stockmarketservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.nimble00.stockmarketservice.models.StockExchange;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@DynamicUpdate
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id")
    private Integer id;
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
