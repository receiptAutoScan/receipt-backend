package com.receipt.www.receiptbackend.revenue.command.application.dto;

public class RevenueMonYearDTO {
    private String monYearDate;
    private Long monYearDay;
    private Long monYearTotal;
    private Long monYearSale;
    private Long monYearActual;
    private Long monYearReceiptNum;
    private Long monYearReceiptPrice;
    private Long monYearReceiptValue;
    private Long monYearlySurtax;

    public RevenueMonYearDTO() {
    }

    public RevenueMonYearDTO(String monYearDate, Long monYearDay, Long monYearTotal, Long monYearSale, Long monYearActual, Long monYearReceiptNum, Long monYearReceiptPrice, Long monYearReceiptValue, Long monYearlySurtax) {
        this.monYearDate = monYearDate;
        this.monYearDay = monYearDay;
        this.monYearTotal = monYearTotal;
        this.monYearSale = monYearSale;
        this.monYearActual = monYearActual;
        this.monYearReceiptNum = monYearReceiptNum;
        this.monYearReceiptPrice = monYearReceiptPrice;
        this.monYearReceiptValue = monYearReceiptValue;
        this.monYearlySurtax = monYearlySurtax;
    }

    public String getMonYearDate() {
        return monYearDate;
    }

    public void setMonYearDate(String monYearDate) {
        this.monYearDate = monYearDate;
    }

    public Long getMonYearDay() {
        return monYearDay;
    }

    public void setMonYearDay(Long monYearDay) {
        this.monYearDay = monYearDay;
    }

    public Long getMonYearTotal() {
        return monYearTotal;
    }

    public void setMonYearTotal(Long monYearTotal) {
        this.monYearTotal = monYearTotal;
    }

    public Long getMonYearSale() {
        return monYearSale;
    }

    public void setMonYearSale(Long monYearSale) {
        this.monYearSale = monYearSale;
    }

    public Long getMonYearActual() {
        return monYearActual;
    }

    public void setMonYearActual(Long monYearActual) {
        this.monYearActual = monYearActual;
    }

    public Long getMonYearReceiptNum() {
        return monYearReceiptNum;
    }

    public void setMonYearReceiptNum(Long monYearReceiptNum) {
        this.monYearReceiptNum = monYearReceiptNum;
    }

    public Long getMonYearReceiptPrice() {
        return monYearReceiptPrice;
    }

    public void setMonYearReceiptPrice(Long monYearReceiptPrice) {
        this.monYearReceiptPrice = monYearReceiptPrice;
    }

    public Long getMonYearReceiptValue() {
        return monYearReceiptValue;
    }

    public void setMonYearReceiptValue(Long monYearReceiptValue) {
        this.monYearReceiptValue = monYearReceiptValue;
    }

    public Long getMonYearlySurtax() {
        return monYearlySurtax;
    }

    public void setMonYearlySurtax(Long monYearlySurtax) {
        this.monYearlySurtax = monYearlySurtax;
    }

    @Override
    public String toString() {
        return "RevenueMonYearDTO{" +
                "monYearDate='" + monYearDate + '\'' +
                ", monYearDay=" + monYearDay +
                ", monYearTotal=" + monYearTotal +
                ", monYearSale=" + monYearSale +
                ", monYearActual=" + monYearActual +
                ", monYearReceiptNum=" + monYearReceiptNum +
                ", monYearReceiptPrice=" + monYearReceiptPrice +
                ", monYearReceiptValue=" + monYearReceiptValue +
                ", monYearlySurtax=" + monYearlySurtax +
                '}';
    }
}
