package com.receipt.www.receiptbackend.revenue.command.domain.aggregate.entity;

import com.receipt.www.receiptbackend.revenue.command.application.dto.RevenueDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "revenue")
@NoArgsConstructor
@Getter
public class RevenueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int revenueNum;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private UserEntity userEntity;
    @Column
    private LocalDate revenueDate;
    @Column
    private String revenueDay;
    @Column
    private int revenueTotal;
    @Column
    private int revenueSale;
    @Column
    private int revenueActual;
    @Column
    private int receiptNum;
    @Column
    private int receiptPrice;
    @Column
    private int receiptValue;
    @Column
    private int surtax;


    public RevenueEntity(RevenueDTO revenueDTO) {
        this.revenueDate = revenueDTO.getRevenueDate();
        this.revenueDay = revenueDTO.getRevenueDay();
        this.revenueTotal = revenueDTO.getRevenueTotal();
        this.revenueSale = revenueDTO.getRevenueSale();
        this.revenueActual = revenueDTO.getRevenueActual();
        this.receiptNum = revenueDTO.getReceiptNum();
        this.receiptPrice = revenueDTO.getReceiptPrice();
        this.receiptValue = revenueDTO.getReceiptValue();
        this.surtax = revenueDTO.getSurtax();
    }
}