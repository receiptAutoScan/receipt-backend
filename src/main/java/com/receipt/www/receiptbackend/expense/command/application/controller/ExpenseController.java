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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ExpenseController {
    private final ExpenseService expenseService;
    private final WebClient webClient;

    public ExpenseController(ExpenseService expenseService, WebClient.Builder webClientBuilder) {
        this.expenseService = expenseService;
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    @PostMapping("/expense")
    public void processExpenseReceiptImg(@RequestParam("images") List<MultipartFile> imageList) {

        // image 그대로 보냄
        Mono<String> returnedData = webClient
                .post()
                .uri("http://172.17.80.174:5000/upload")
                .headers(headers -> {
                    headers.add("Content-Type", "multipart/form-data");
                })
                .body(BodyInserters.fromMultipartData("file", imageList.get(0)))
                .retrieve()
                .onStatus(
                        HttpStatus::is4xxClientError,
                        clientResponse -> {
                            return Mono.error(new RuntimeException("Client Error: " + clientResponse.statusCode()));
                        }
                ).onStatus(
                        HttpStatus::is5xxServerError,
                        clientResponse -> {
                            return Mono.error(new RuntimeException("Server Error: " + clientResponse.statusCode()));
                        }
                )
                .bodyToMono(String.class);

        returnedData.block();
    }

    @PostMapping("/expense/list")
    public void createExpenseList(@RequestBody List<CreateExpenseDTO> createExpenseDTOList) {
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
