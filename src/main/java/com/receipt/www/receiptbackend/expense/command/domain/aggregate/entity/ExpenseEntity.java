package com.receipt.www.receiptbackend.expense.command.domain.aggregate.entity;

import com.receipt.www.receiptbackend.expense.command.application.dto.CreateExpenseDTO;
import com.receipt.www.receiptbackend.expense.command.application.dto.UpdateExpenseDTO;
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

    public ExpenseEntity(CreateExpenseDTO createExpenseDTO) {
        this.businessPartner = createExpenseDTO.getBusinessPartner();
        this.transactionDate = createExpenseDTO.getTransactionDate();
        this.itemPrice = createExpenseDTO.getItemPrice();
        this.itemName = createExpenseDTO.getItemName();
    }

    public ExpenseEntity(UpdateExpenseDTO updateExpenseDTO) {
        this.expenseId = updateExpenseDTO.getExpenseId();
        this.businessPartner = updateExpenseDTO.getBusinessPartner();
        this.transactionDate = updateExpenseDTO.getTransactionDate();
        this.itemPrice = updateExpenseDTO.getItemPrice();
        this.itemName = updateExpenseDTO.getItemName();
    }

}
