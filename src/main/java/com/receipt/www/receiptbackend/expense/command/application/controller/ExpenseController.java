package com.receipt.www.receiptbackend.expense.command.application.controller;

import com.receipt.www.receiptbackend.expense.command.application.dto.CreateExpenseDTO;
import com.receipt.www.receiptbackend.expense.command.application.dto.UpdateExpenseDTO;
import com.receipt.www.receiptbackend.expense.command.application.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("/expense")
    public void processExpenseReceiptImg(@RequestParam("images") MultipartFile[] imageList) {
        expenseService.processReceiptImg(imageList);
    }

    @PostMapping("/chatbot")
    public String chatbotConnect(@RequestParam String message) {
        System.out.println("message: " + message);
        return expenseService.chatbotConnect(message);
    }

    @PostMapping("/expense/list")
    public void createExpenseList(@RequestBody List<CreateExpenseDTO> createExpenseDTOList) {
        expenseService.createExpenseList(createExpenseDTOList);
    }

    @PutMapping("/expense/{expenseId}")
    public void updateExpense(@PathVariable Long expenseId, @RequestBody UpdateExpenseDTO updateExpenseDTO) {

        expenseService.updateExpense(expenseId, updateExpenseDTO);
    }

    @DeleteMapping("/expense/{expenseId}")
    public void deleteExpense(@PathVariable Long expenseId) {

        expenseService.deleteExpense(expenseId);
    }
}
