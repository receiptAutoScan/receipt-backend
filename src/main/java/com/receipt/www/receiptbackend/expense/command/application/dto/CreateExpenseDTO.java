package com.receipt.www.receiptbackend.expense.command.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Getter
@Setter
public class CreateExpenseDTO {

    @JsonProperty("거래처")
    private String businessPartner;
    @JsonProperty("날짜")
    private String transactionDate;
    @JsonProperty("금액")
    private String itemPrice;
    @JsonProperty("품목")
    private String itemName;
    public CreateExpenseDTO() {
    }

//    public CreateExpenseDTO(String businessPartner, String transactionDate, Long itemPrice, String itemName) {
//        this.businessPartner = businessPartner;
//        this.transactionDate = transactionDate;
//        this.itemPrice = itemPrice;
//        this.itemName = itemName;
//    }
}
