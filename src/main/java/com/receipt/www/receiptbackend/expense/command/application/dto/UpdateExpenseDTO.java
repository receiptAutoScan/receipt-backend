package com.receipt.www.receiptbackend.expense.command.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateExpenseDTO {

    private Long expenseId;
    private String businessPartner;
    private LocalDate transactionDate;
    private Long itemPrice;
    private String itemName;

    public UpdateExpenseDTO(Long expenseId, String businessPartner, LocalDate transactionDate, Long itemPrice, String itemName) {
        this.expenseId = expenseId;
        this.businessPartner = businessPartner;
        this.transactionDate = transactionDate;
        this.itemPrice = itemPrice;
        this.itemName = itemName;
    }
}
