package com.receipt.www.receiptbackend.revenue.command.application.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.receipt.www.receiptbackend.expense.command.application.dto.CreateExpenseDTO;
import com.receipt.www.receiptbackend.expense.command.application.dto.UpdateExpenseDTO;
import com.receipt.www.receiptbackend.expense.command.application.service.ExpenseService;
import com.receipt.www.receiptbackend.revenue.command.application.dto.RevenueDTO;
import com.receipt.www.receiptbackend.revenue.command.application.service.RevenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RevenueRestController {

    private final RevenueService revenueService;

    public RevenueRestController(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    @PostMapping(value = "/revenue")
    public ResponseEntity<?> uploadExcel(@RequestBody List<Map<String, Object>> data) {
    //      List<Map<String , Object >> dataset;
    //      dataset = new ObjectMapper().readValue((String) data.get("body"),new TypeReference<List<Map<String, Object>>>() { });
        HttpStatus status;
        try {
            revenueService.uploadExcel(data);
            status = HttpStatus.CREATED;
        } catch (ParseException e) {
            status = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity
                .status(status).build();
    }

    @DeleteMapping("/revenue/{revenueNum}")
    public ResponseEntity<?> deleteExcel(@PathVariable Long revenueNum) {
        HttpStatus status;
        revenueService.deleteExcel(revenueNum);
        status = HttpStatus.CREATED;

        return ResponseEntity
                .status(status).build();

    }
}
