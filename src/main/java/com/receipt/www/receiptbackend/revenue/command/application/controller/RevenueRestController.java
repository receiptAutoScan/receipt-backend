package com.receipt.www.receiptbackend.revenue.command.application.controller;


import com.receipt.www.receiptbackend.expense.command.application.dto.CreateExpenseDTO;
import com.receipt.www.receiptbackend.expense.command.application.dto.UpdateExpenseDTO;
import com.receipt.www.receiptbackend.expense.command.application.service.ExpenseService;
import com.receipt.www.receiptbackend.revenue.command.application.dto.RevenueDTO;
import com.receipt.www.receiptbackend.revenue.command.application.service.RevenueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
public class RevenueRestController {

    private final RevenueService revenueService;

    public RevenueRestController(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    @PostMapping(value = "/revenue",produces = "application/json; charset=utf-8")
    public void uploadExcel(@RequestBody Map<String , Object> data) {
        System.out.println(data);
//        revenueService.uploadExcel(data);
    }

    @DeleteMapping("/revenue/{revenueNum}")
    public void deleteExcel(@PathVariable Long revenueNum) {

        revenueService.deleteExcel(revenueNum);
    }
}
