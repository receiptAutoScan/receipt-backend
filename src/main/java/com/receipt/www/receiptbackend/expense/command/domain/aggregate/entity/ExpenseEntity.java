package com.receipt.www.receiptbackend.expense.command.domain.aggregate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "expense")
@NoArgsConstructor
@Getter
public class ExpenseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private UserEntity userEntity;

    @Column
    private String businessPartner;

    @Column
    private LocalDate transactionDate;

    @Column
    private Long itemPrice;

    @Column
    private String itemName;

    @Column
    @CreatedDate
    private LocalDate createdDate;

    @PrePersist
    public void prePersist() {
        this.createdDate = LocalDate.now();
    }

}
