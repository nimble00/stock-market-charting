package com.nimble00.companyservice.models;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import com.nimble00.companyservice.models.StockExchange;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@DynamicUpdate
public class StockPrice {
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String ticker;
    private float currentPrice;
    private String stockExchange;
    private String currentDate;
    private String timeStamp;
}
