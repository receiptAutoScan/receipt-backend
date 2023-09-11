package com.receipt.www.receiptbackend.revenue.command.application.dto;

import java.time.LocalDate;

public class RevenueDTO {
    private int revenueNum;
    private LocalDate revenueDate;
    private String revenueDay;
    private int revenueTotal;
    private int revenueSale;
    private int revenueActual;
    private int receiptNum;
    private int receiptPrice;
    private int receiptValue;
    private int surtax;


    public RevenueDTO(int revenueNum, LocalDate revenueDate, String revenueDay, int revenueTotal, int revenueSale, int revenueActual, int receiptNum, int receiptPrice, int receiptValue, int surtax) {
        this.revenueNum = revenueNum;
        this.revenueDate = revenueDate;
        this.revenueDay = revenueDay;
        this.revenueTotal = revenueTotal;
        this.revenueSale = revenueSale;
        this.revenueActual = revenueActual;
        this.receiptNum = receiptNum;
        this.receiptPrice = receiptPrice;
        this.receiptValue = receiptValue;
        this.surtax = surtax;
    }

    @Override
    public String toString() {
        return "Test{" +
                "revenueNum=" + revenueNum +
                ", revenueDate=" + revenueDate +
                ", revenueDay='" + revenueDay + '\'' +
                ", revenueTotal=" + revenueTotal +
                ", revenueSale=" + revenueSale +
                ", revenueActual=" + revenueActual +
                ", receiptNum=" + receiptNum +
                ", receiptPrice=" + receiptPrice +
                ", receiptValue=" + receiptValue +
                ", surtax=" + surtax +
                '}';
    }

    public int getRevenueNum() {
        return revenueNum;
    }

    public void setRevenueNum(int revenueNum) {
        this.revenueNum = revenueNum;
    }

    public LocalDate getRevenueDate() {
        return revenueDate;
    }

    public void setRevenueDate(LocalDate revenueDate) {
        this.revenueDate = revenueDate;
    }

    public String getRevenueDay() {
        return revenueDay;
    }

    public void setRevenueDay(String revenueDay) {
        this.revenueDay = revenueDay;
    }

    public int getRevenueTotal() {
        return revenueTotal;
    }

    public void setRevenueTotal(int revenueTotal) {
        this.revenueTotal = revenueTotal;
    }

    public int getRevenueSale() {
        return revenueSale;
    }

    public void setRevenueSale(int revenueSale) {
        this.revenueSale = revenueSale;
    }

    public int getRevenueActual() {
        return revenueActual;
    }

    public void setRevenueActual(int revenueActual) {
        this.revenueActual = revenueActual;
    }

    public int getReceiptNum() {
        return receiptNum;
    }

    public void setReceiptNum(int receiptNum) {
        this.receiptNum = receiptNum;
    }

    public int getReceiptPrice() {
        return receiptPrice;
    }

    public void setReceiptPrice(int receiptPrice) {
        this.receiptPrice = receiptPrice;
    }

    public int getReceiptValue() {
        return receiptValue;
    }

    public void setReceiptValue(int receiptValue) {
        this.receiptValue = receiptValue;
    }

    public int getSurtax() {
        return surtax;
    }

    public void setSurtax(int surtax) {
        this.surtax = surtax;
    }
}
