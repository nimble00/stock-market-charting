package com.stock.entity;

import java.util.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name="stock_price")
public class StockPrice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	
	@Column(name="current_price")
	private float currentPrice;
	
	private Date date;
	
	private String time;
	
	public StockPrice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StockPrice(Company company, Float currentPrice, Date date, String time) {
		super();
		this.company = company;
		this.currentPrice = currentPrice;
		this.date = date;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Float getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(Float currentPrice) {
		this.currentPrice = currentPrice;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
