package com.receipt.www.receiptbackend.revenue.query.application.controller;



import com.receipt.www.receiptbackend.revenue.query.application.dto.RevenueDTO;
import com.receipt.www.receiptbackend.revenue.query.application.service.RevenueService;
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
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RevenueRestController {

    private final RevenueService revenueService;

    @Autowired
    public RevenueRestController(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    @GetMapping("/revenue")
    public ResponseEntity<RevenueDTO> inquireExcel(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));

        Map<String , Object> responseMap =new HashMap<>();
        try {
            responseMap.put("users",revenueService.inquireExcel());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        return new ResponseEntity<>(responseMessage,headers, HttpStatus.OK);
    }
}
