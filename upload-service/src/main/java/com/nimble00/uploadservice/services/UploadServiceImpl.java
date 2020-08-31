package com.nimble00.uploadservice.services;

import com.nimble00.uploadservice.models.StockPrice;
import com.nimble00.uploadservice.repository.StockPriceRepo;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

@Service
@Transactional
public class UploadServiceImpl implements UploadService {

    private StockPriceRepo stockPriceRepo;
    private Model model;

    public UploadServiceImpl(StockPriceRepo stockPriceRepo, Model model) {
        this.stockPriceRepo = stockPriceRepo;
        this.model = model;
    }

    private String fileLocation;

    @Override
    public List<StockPrice> importExcel2DB(Model model, MultipartFile file) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new File(model.getAttribute("file")));

    }

    @Override
    public Object getUploadSummary(Model model,List<StockPrice> stockPriceList) {
        return null;
    }
}
