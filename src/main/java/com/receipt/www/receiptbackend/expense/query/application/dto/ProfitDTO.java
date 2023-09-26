package com.receipt.www.receiptbackend.expense.query.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfitDTO {
    private String transactionMonth;
    private String expenseTotalPrice;
    private String revenueTotalPrice;
    private String profit;

}
