package com.nimble00.uploadservice.services;

import com.nimble00.uploadservice.models.StockPrice;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadService {
//    void uploadFile(MultipartFile file) throws Exception;
    List<StockPrice> importExcel2DB(Model model, MultipartFile file) throws Exception;
    Object getUploadSummary(Model model, List<StockPrice> stockPriceList);
}
