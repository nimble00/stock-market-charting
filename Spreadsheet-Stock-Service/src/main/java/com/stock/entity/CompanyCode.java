package com.stock.entity;

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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name="company_code")
@Entity
public class CompanyCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id")
	private int id;
	
	@Column(name="value")
	private String value;
	
	@Column(name="exchange_name")
	private String exchangeName;
	
	@ManyToOne
	private Company company;
	
	public CompanyCode() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompanyCode(String value, String exchangeName) {
		super();
		this.value = value;
		this.exchangeName = exchangeName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getExchangeName() {
		return exchangeName;
	}
	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	
}
