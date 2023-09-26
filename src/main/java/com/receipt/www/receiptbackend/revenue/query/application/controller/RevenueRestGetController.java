package com.receipt.www.receiptbackend.revenue.query.application.controller;




import com.receipt.www.receiptbackend.revenue.command.application.dto.RevenueDTO;
import com.receipt.www.receiptbackend.revenue.command.application.dto.RevenueMonYearDTO;
import com.receipt.www.receiptbackend.revenue.query.application.dto.RevenueMonthlyDTO;
import com.receipt.www.receiptbackend.revenue.query.application.service.RevenueGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RevenueRestGetController {

    private final RevenueGetService revenueGetService;

    @Autowired
    public RevenueRestGetController(RevenueGetService revenueGetService) {
        this.revenueGetService = revenueGetService;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/revenueDay")
    public ResponseEntity<List<RevenueDTO>> inquireExcelDay() throws ParseException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));

        return new ResponseEntity<>(revenueGetService.inquireExcelByDay(),headers, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/revenue/monthly")
    public ResponseEntity<List<RevenueMonthlyDTO>> inquireExcelMonth() throws ParseException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));

        return new ResponseEntity<>(revenueGetService.inquireExcelByMonth(),headers, HttpStatus.OK);
    }
//    @CrossOrigin(origins = "http://localhost:3000")
//    @GetMapping("/revenueYear")
//    public ResponseEntity<List<RevenueMonYearDTO>> inquireExcelYear() throws ParseException {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));
//
//        return new ResponseEntity<>(revenueGetService.inquireExcelByYear(),headers, HttpStatus.OK);
//    }
}
