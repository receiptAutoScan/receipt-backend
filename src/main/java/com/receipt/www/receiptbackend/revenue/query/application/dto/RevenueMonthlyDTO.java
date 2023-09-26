package com.receipt.www.receiptbackend.revenue.query.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RevenueMonthlyDTO {

    private String transactionMonth;
    private Long itemTotalPrice;

    public RevenueMonthlyDTO() {
    }

    public RevenueMonthlyDTO(String transactionMonth, Long itemTotalPrice) {
        this.transactionMonth = transactionMonth;
        this.itemTotalPrice = itemTotalPrice;
    }
}
