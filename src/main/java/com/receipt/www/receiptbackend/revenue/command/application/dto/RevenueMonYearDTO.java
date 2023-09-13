package com.receipt.www.receiptbackend.revenue.command.application.dto;

public class RevenueMonYearDTO {
    private String monYearDate;
    private int monYearDay;
    private int monYearTotal;
    private int monYearSale;
    private int monYearActual;
    private int monYearReceiptNum;
    private int monYearReceiptPrice;
    private int monYearReceiptValue;
    private int monYearlySurtax;

    public RevenueMonYearDTO() {
    }

    public RevenueMonYearDTO(String monYearDate, int monYearDay, int monYearTotal, int monYearSale, int monYearActual, int monYearReceiptNum, int monYearReceiptPrice, int monYearReceiptValue, int monYearlySurtax) {
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

    public int getMonYearDay() {
        return monYearDay;
    }

    public void setMonYearDay(int monYearDay) {
        this.monYearDay = monYearDay;
    }

    public int getMonYearTotal() {
        return monYearTotal;
    }

    public void setMonYearTotal(int monYearTotal) {
        this.monYearTotal = monYearTotal;
    }

    public int getMonYearSale() {
        return monYearSale;
    }

    public void setMonYearSale(int monYearSale) {
        this.monYearSale = monYearSale;
    }

    public int getMonYearActual() {
        return monYearActual;
    }

    public void setMonYearActual(int monYearActual) {
        this.monYearActual = monYearActual;
    }

    public int getMonYearReceiptNum() {
        return monYearReceiptNum;
    }

    public void setMonYearReceiptNum(int monYearReceiptNum) {
        this.monYearReceiptNum = monYearReceiptNum;
    }

    public int getMonYearReceiptPrice() {
        return monYearReceiptPrice;
    }

    public void setMonYearReceiptPrice(int monYearReceiptPrice) {
        this.monYearReceiptPrice = monYearReceiptPrice;
    }

    public int getMonYearReceiptValue() {
        return monYearReceiptValue;
    }

    public void setMonYearReceiptValue(int monYearReceiptValue) {
        this.monYearReceiptValue = monYearReceiptValue;
    }

    public int getMonYearlySurtax() {
        return monYearlySurtax;
    }

    public void setMonYearlySurtax(int monYearlySurtax) {
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
