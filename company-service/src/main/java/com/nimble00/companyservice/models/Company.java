package com.nimble00.companyservice.models;

import lombok.Data;
import com.nimble00.companyservice.models.StockExchange;
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
    private String turnover;
    private String ceo;
    private String boardOfDirs;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinColumn(name = "orders",nullable = false)
    @JoinTable(
            name = "company_stockexchange",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "stockexchange_id")
    )
    private List<StockExchange> stockExchangeList;
    private String sector;
    private String briefWriteup;
    private String ticker;
}
