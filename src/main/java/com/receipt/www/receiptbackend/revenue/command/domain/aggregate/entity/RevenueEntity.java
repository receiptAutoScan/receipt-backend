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
    private int revenuePrice;
    @Column
    private String revenueType;
    @Column
    private String revenuePoint;


    public RevenueEntity(RevenueDTO revenueDTO) {
        this.revenueDate = revenueDTO.getRevenueDate();
        this.revenuePoint = revenueDTO.getRevenuePoint();
        this.revenueType = revenueDTO.getRevenueType();
        this.revenuePrice = revenueDTO.getRevenuePrice();
    }
}