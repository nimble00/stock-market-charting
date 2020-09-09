package com.stock.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.stock.dao.CompanyCodeDAO;
import com.stock.dao.StockPriceDAO;
import com.stock.dto.NewStock;
import com.stock.dto.SummaryDTO;
import com.stock.entity.Company;
import com.stock.entity.CompanyCode;
import com.stock.entity.StockPrice;
import com.stock.excelHelp.Helper;

@Service
public class StockServiceImpl implements StockService {
	

	@Autowired
	StockPriceDAO stockPriceDao;
	@Autowired
	CompanyCodeDAO companyCodeDao;
	
	@Transactional
	public List<String> uploadStockData(MultipartFile file) throws Exception {
		try {
			
			String fileName = file.getOriginalFilename();
			String fileType = fileName.substring(fileName.lastIndexOf("."));
	        if (!(fileType.equals(".xls") || fileType.equals(".xlsx") || fileType.equals(".csv"))) 
	        {
	        	throw new Exception("Please upload an excel file");
	        }
	        
        	List<NewStock> spList = Helper.readExcel(file.getInputStream());
        	List<String> summary = new ArrayList<String>();
        	summary.add("========== Spreadsheet Upload Summary =========");
        	String code=null;
        	Company company = new Company();
			for(NewStock i : spList)
			{

				if(code != i.getCompanyCode()) {
		        	CompanyCode cc = companyCodeDao.findByValue(i.getCompanyCode());
					if(cc!=null)
					{	
						code = i.getCompanyCode();
						company = cc.getCompany();
						StockPrice sp = new StockPrice();
						sp.setCompany(company);
						sp.setCurrentPrice((float)i.getCurrentPrice());
						sp.setDate(i.getDate());
						sp.setTime(i.getTime());
						stockPriceDao.save(sp);
						summary.add("Successfull : "+i.toString());
					}
					else
					{
						summary.add("Invalid Entry : "+i.toString());
					}
					
				}
				else
				{
					StockPrice sp = new StockPrice();
					sp.setCompany(company);
					sp.setCurrentPrice((float)i.getCurrentPrice());
					sp.setDate(i.getDate());
					sp.setTime(i.getTime());
					stockPriceDao.save(sp);
					summary.add("Successfull : "+i.toString());
				}
			}
			return summary;

		}
		
		catch(IOException e){
			throw new RuntimeException("fail" + e.getMessage());
		}
	}

	@Override
	public List<StockPrice> listALL() {
		return stockPriceDao.findAll();
	}

}
