package com.receipt.www.receiptbackend.expense.command.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.receipt.www.receiptbackend.expense.command.application.dto.CreateExpenseDTO;
import com.receipt.www.receiptbackend.expense.command.application.dto.UpdateExpenseDTO;
import com.receipt.www.receiptbackend.expense.command.domain.aggregate.entity.ExpenseEntity;
import com.receipt.www.receiptbackend.expense.command.infra.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Value("${upload-dir}")
    private String uploadDirectory;

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

    @Transactional
    public void processReceiptImg(MultipartFile[] imageList) {
        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Create headers with content type as multipart/form-data
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        // Create a MultiValueMap to store form data
        MultiValueMap<String, Object> formData = new LinkedMultiValueMap<>();

        for (MultipartFile image : imageList) {
            if(!image.isEmpty()) {
                try {

                    // Generate a unique file name for each uploaded file
                    String originalFilename = image.getOriginalFilename();
                    String uniqueFilename = System.currentTimeMillis() + "_" + originalFilename;
                    String targetFilePath = uploadDirectory + File.separator + uniqueFilename;

                    System.out.println(uploadDirectory);

                    Path targetDirectory = Paths.get(uploadDirectory);

                    if(!Files.exists(targetDirectory)) {
                        Files.createDirectories(targetDirectory);
                    }

                    // Copy file to the target location (Replacing existing file with the same name
                    Files.write(Paths.get(targetFilePath), image.getBytes());

                    // Add the saved file to the form data
                    formData.add("files1", new FileSystemResource(new File(targetFilePath)));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Create a request entity with headers and form data
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(formData, headers);

        // Send a POST request to the server
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "http://192.168.0.3:5000/upload",
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        // Retrieve the response body
        String response = responseEntity.getBody();
        System.out.println(response);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        CreateExpenseDTO createExpenseDTO = null;

        try {
            createExpenseDTO = mapper.readValue(response, CreateExpenseDTO.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        ExpenseEntity expenseEntity = new ExpenseEntity(createExpenseDTO);

        expenseRepository.save(expenseEntity);
    }


    public String chatbotConnect(String message) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

        map.add("message", message);

        System.out.println(map.get("message"));

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(map, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "http://192.168.0.3:5000/chatbot",
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        String response = responseEntity.getBody();
        System.out.println(response);

        return response;
    }
}
