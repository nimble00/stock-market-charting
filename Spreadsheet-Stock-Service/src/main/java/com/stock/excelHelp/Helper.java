package com.stock.excelHelp;

//import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import com.stock.dto.NewStock;



public class Helper {
	
	public static List<NewStock> readExcel(InputStream is){
		
		try {
			
			Workbook workbook = new XSSFWorkbook(is);
			
			if (workbook == null) 
			{
                throw new Exception("workbook is empty！");
            }
			
			
			List<NewStock> priceList = new ArrayList<NewStock>();
			
			int n = workbook.getNumberOfSheets();
			
			for(int i = 0; i < n; i++) {
				
				Sheet sheet = workbook.getSheetAt(i);
			    Iterator<Row> rows = null;
			    rows=sheet.iterator();
			    if(rows.hasNext())
			    {
			    rows.next();
			    
			    
			    while(rows.hasNext()) {
			    	Row currentRow = rows.next();
			    	Iterator<Cell> cells = currentRow.iterator();
			    	
			    	NewStock sp = new NewStock();
			    	String s=cells.next().getStringCellValue();
			    	String cc=s.replaceAll("[^\\x00-\\x7F]","");
			    	sp.setCompanyCode(cc);
			    	sp.setStockExchange(cells.next().getStringCellValue());
			    	sp.setCurrentPrice(cells.next().getNumericCellValue());
			    	sp.setDate(cells.next().getDateCellValue());
			    	sp.setTime(cells.next().getStringCellValue());
			    	
			    	priceList.add(sp);
			    	
			    	
			    }	
			    }
			}
		    
		    workbook.close();	   
		    return priceList;
		}
		
		catch(Exception e) {
			throw new RuntimeException("Failed to parse file " + e.getMessage());
		}
		
	}

}