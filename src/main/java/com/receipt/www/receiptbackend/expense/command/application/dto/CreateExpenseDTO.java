package com.receipt.www.receiptbackend.expense.command.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Getter
@Setter
public class CreateExpenseDTO {
    private String businessPartner;
    private LocalDate transactionDate;
    private Long itemPrice;
    private String itemName;

    public CreateExpenseDTO(String businessPartner, String transactionDate, Long itemPrice, String itemName) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(Locale.KOREA);

        this.businessPartner = businessPartner;
        this.transactionDate = LocalDate.parse(transactionDate, formatter);
        this.itemPrice = itemPrice;
        this.itemName = itemName;
    }
}
