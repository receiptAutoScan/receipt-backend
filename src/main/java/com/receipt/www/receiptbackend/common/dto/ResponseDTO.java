package com.receipt.www.receiptbackend.common.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ResponseDTO {

    private int httpStatus;
    private String message;
    private Map<String, Object> results;


}
