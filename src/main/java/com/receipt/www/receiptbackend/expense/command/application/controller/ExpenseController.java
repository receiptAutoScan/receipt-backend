package com.receipt.www.receiptbackend.expense.command.application.controller;

import com.receipt.www.receiptbackend.expense.command.application.dto.CreateExpenseDTO;
import com.receipt.www.receiptbackend.expense.command.application.dto.UpdateExpenseDTO;
import com.receipt.www.receiptbackend.expense.command.application.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("/expense")
    public void createExpenseList(@RequestBody List<CreateExpenseDTO> createExpenseDTOList) {
        System.out.println("dwqdwq");
        expenseService.createExpenseList(createExpenseDTOList);
    }

    @PutMapping("/expense/{expenseId}")
    public void updateExpense(@PathVariable Long expenseId, @RequestBody UpdateExpenseDTO updateExpenseDTO) {

        updateExpenseDTO.setExpenseId(expenseId);

        expenseService.updateExpense(updateExpenseDTO);
    }

    @DeleteMapping("/expense/{expenseId}")
    public void deleteExpense(@PathVariable Long expenseId) {

        expenseService.deleteExpense(expenseId);
    }
}
