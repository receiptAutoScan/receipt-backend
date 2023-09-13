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
    private final WebClient webClient;

    public ExpenseController(ExpenseService expenseService, WebClient.Builder webClientBuilder) {
        this.expenseService = expenseService;
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    @PostMapping("/expense")
    public void processExpenseReceiptImg(@RequestParam("images") List<MultipartFile> imageList) {
        System.out.println("imageList: " + imageList);

        // image 그대로 보냄
//        Mono<String> returnedData = webClient
//                .post()
//                .uri("/upload")
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromValue(imageList))
//                .retrieve()
//                .onStatus(
//                        HttpStatus::is4xxClientError,
//                        clientResponse -> {
//                            return Mono.error(new RuntimeException("Client Error: " + clientResponse.statusCode()));
//                        }
//                ).onStatus(
//                        HttpStatus::is5xxServerError,
//                        clientResponse -> {
//                            return Mono.error(new RuntimeException("Server Error: " + clientResponse.statusCode()));
//                        }
//                )
//                .bodyToMono(String.class);
//
//        // 받아온 사항들 insert 처리
//        createExpenseList(new ArrayList<>());
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
