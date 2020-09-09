package com.stock.dto;

import java.util.Date;

public class NewStock {
	
	private String companyCode;
	private String stockExchange;
	private double currentPrice;
	private Date date;
	private String time;
	public NewStock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NewStock(String companyCode, String stockExchange, double currentPrice, Date date, String time) {
		super();
		this.companyCode = companyCode;
		this.stockExchange = stockExchange;
		this.currentPrice = currentPrice;
		this.date = date;
		this.time = time;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	public double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(double d) {
		this.currentPrice = d;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date2) {
		this.date = date2;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "NewStock [companyCode=" + companyCode + ", stockExchange=" + stockExchange + ", currentPrice="
				+ currentPrice + ", date=" + date + ", time=" + time + "]";
	}
	
	

}
