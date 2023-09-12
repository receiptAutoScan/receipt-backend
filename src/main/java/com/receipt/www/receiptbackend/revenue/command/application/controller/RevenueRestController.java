package com.receipt.www.receiptbackend.revenue.command.application.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.receipt.www.receiptbackend.expense.command.application.dto.CreateExpenseDTO;
import com.receipt.www.receiptbackend.expense.command.application.dto.UpdateExpenseDTO;
import com.receipt.www.receiptbackend.expense.command.application.service.ExpenseService;
import com.receipt.www.receiptbackend.revenue.command.application.dto.RevenueDTO;
import com.receipt.www.receiptbackend.revenue.command.application.service.RevenueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public void uploadExcel(@RequestBody Map<String , Object> data) {
        List<Map<String , Object >> dataset;
        try {
            dataset = new ObjectMapper().readValue((String) data.get("body"),new TypeReference<List<Map<String, Object>>>() { });
            System.out.println(dataset);
            revenueService.uploadExcel(dataset);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    @DeleteMapping("/revenue/{revenueNum}")
    public void deleteExcel(@PathVariable Long revenueNum) {

        revenueService.deleteExcel(revenueNum);
    }
}
