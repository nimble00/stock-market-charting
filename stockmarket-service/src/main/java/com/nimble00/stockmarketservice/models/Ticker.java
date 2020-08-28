package com.nimble00.stockmarketservice.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
public class Ticker {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticker_id")
    private Integer id;
    private String name;
}
