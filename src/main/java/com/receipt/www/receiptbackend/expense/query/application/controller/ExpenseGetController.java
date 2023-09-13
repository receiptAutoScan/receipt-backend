package com.receipt.www.receiptbackend.expense.query.application.controller;

import com.receipt.www.receiptbackend.expense.command.domain.aggregate.entity.ExpenseEntity;
import com.receipt.www.receiptbackend.expense.query.application.service.ExpenseGetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpenseGetController {

    private final ExpenseGetService expenseGetService;

    public ExpenseGetController(ExpenseGetService expenseGetService) {
        this.expenseGetService = expenseGetService;
    }

    @GetMapping("/expense")
    public List<ExpenseEntity> getAllExpenses() {
        return expenseGetService.getAllExpenses();
    }
}
