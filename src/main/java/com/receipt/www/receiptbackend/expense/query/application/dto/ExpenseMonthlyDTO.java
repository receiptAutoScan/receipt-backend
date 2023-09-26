package com.receipt.www.receiptbackend.expense.query.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseMonthlyDTO {
    private String transactionMonth;
    private Long itemTotalPrice;

    public ExpenseMonthlyDTO() {
    }

    public ExpenseMonthlyDTO(String transactionMonth, Long itemTotalPrice) {
        this.transactionMonth = transactionMonth;
        this.itemTotalPrice = itemTotalPrice;
    }
}
