package com.stock.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name= "company")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id")
	private int id;
	
	@Column(name = "company_id",nullable = false,unique=true)
	private String company_id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "turnover", nullable = false)
	private float turnover;
	
	@Column(name = "ceo", nullable  = false)
	private String ceo;
	
	@Column(name = "directors", nullable  = false, columnDefinition = "TEXT")
	private String directors;
	
	@Column(name = "brief", nullable = false, columnDefinition = "TEXT")
	private String brief;
	
	@JsonIgnore
	@OneToMany(mappedBy="company", cascade=CascadeType.ALL,orphanRemoval = true)
	private List<CompanyCode> companyCode = new ArrayList<CompanyCode>();
	
	@JsonIgnore
	@OneToMany(mappedBy ="company",orphanRemoval=true, cascade = CascadeType.ALL)
	private List<StockPrice> stockPrice=new ArrayList<StockPrice>();

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(String company_id, String name, float turnover, String ceo, String directors, String brief) {
		super();
		this.company_id = company_id;
		this.name = name;
		this.turnover = turnover;
		this.ceo = ceo;
		this.directors = directors;
		this.brief = brief;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany_id() {
		return company_id;
	}

	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getTurnover() {
		return turnover;
	}

	public void setTurnover(float turnover) {
		this.turnover = turnover;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getDirectors() {
		return directors;
	}

	public void setDirectors(String directors) {
		this.directors = directors;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public List<CompanyCode> getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(List<CompanyCode> companyCode) {
		this.companyCode = companyCode;
	}


	public List<StockPrice> getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(List<StockPrice> stockPrice) {
		this.stockPrice = stockPrice;
	}
}
