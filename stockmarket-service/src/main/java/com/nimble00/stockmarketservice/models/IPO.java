package com.nimble00.stockmarketservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class IPO {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ipo_id")
    private Integer id;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "company_exchange", joinColumns = {@JoinColumn(name = "company_id") },
            inverseJoinColumns = {@JoinColumn(name = "exchange_id") })
    private Company companyName;
    private String stockExchange;
    private String sharePrice;
    private Long numShares;
    private String dateTime;
    private String remarks;
}
