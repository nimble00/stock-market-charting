package com.nimble00.uploadservice.models;

import lombok.Data;

@Data
public class Metadata {
    private int numRecords;
    private String companyName;
    private String stockExchange;
    private String fromDate;
    private String toDate;
}
