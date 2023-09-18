package com.receipt.www.receiptbackend.expense.command.application.service;

import com.receipt.www.receiptbackend.expense.command.application.dto.CreateExpenseDTO;
import com.receipt.www.receiptbackend.expense.command.application.dto.UpdateExpenseDTO;
import com.receipt.www.receiptbackend.expense.command.domain.aggregate.entity.ExpenseEntity;
import com.receipt.www.receiptbackend.expense.command.infra.repository.ExpenseRepository;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    //    private final String AI_URL = "http://221.163.19.218:8282";
    private final String AI_URL = "http://192.168.0.53:5000";

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Transactional
    public void createExpenseList(List<CreateExpenseDTO> createExpenseDTOList) {

        for (CreateExpenseDTO createExpenseDTO : createExpenseDTOList) {

            ExpenseEntity expenseEntity = new ExpenseEntity(createExpenseDTO);

            expenseRepository.save(expenseEntity);
        }
    }

    @Transactional
    public void updateExpense(UpdateExpenseDTO updateExpenseDTO) {

        expenseRepository.getReferenceById(updateExpenseDTO.getExpenseId());

        ExpenseEntity expenseEntity = new ExpenseEntity(updateExpenseDTO);

        expenseRepository.save(expenseEntity);
    }

    @Transactional
    public void deleteExpense(Long expenseId) {

        expenseRepository.deleteById(expenseId);
    }

    public void processReceiptImg(MultipartFile[] imageList) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> formData = new LinkedMultiValueMap<>();

        for(MultipartFile image : imageList) {
            try {
                byte[] imageBytes = image.getBytes();
                Resource resource = new ByteArrayResource(imageBytes);

                formData.add("files", new HttpEntity<>(resource));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(formData, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                AI_URL + "/upload",
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        String response = responseEntity.getBody();
        System.out.println(response);
    }

}
