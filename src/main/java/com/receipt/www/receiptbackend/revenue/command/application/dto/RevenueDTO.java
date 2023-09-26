package com.receipt.www.receiptbackend.revenue.command.application.dto;

import javax.persistence.Column;
import java.time.LocalDate;

public class RevenueDTO {


    private LocalDate revenueDate;

    private int revenuePrice;

    private String revenueType;

    private String revenuePoint;



    public RevenueDTO() {
    }

    public RevenueDTO(LocalDate revenueDate, String revenuePoint, String revenueType, int revenuePrice) {
        this.revenueDate = revenueDate;
        this.revenuePrice = revenuePrice;
        this.revenueType = revenueType;
        this.revenuePoint = revenuePoint;
    }

    public LocalDate getRevenueDate() {
        return revenueDate;
    }

    public void setRevenueDate(LocalDate revenueDate) {
        this.revenueDate = revenueDate;
    }

    public int getRevenuePrice() {
        return revenuePrice;
    }

    public void setRevenuePrice(int revenuePrice) {
        this.revenuePrice = revenuePrice;
    }

    public String getRevenueType() {
        return revenueType;
    }

    public void setRevenueType(String revenueType) {
        this.revenueType = revenueType;
    }

    public String getRevenuePoint() {
        return revenuePoint;
    }

    public void setRevenuePoint(String revenuePoint) {
        this.revenuePoint = revenuePoint;
    }
}
