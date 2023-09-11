package com.receipt.www.receiptbackend.expense.command.infra.repository;

import com.receipt.www.receiptbackend.expense.command.domain.aggregate.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {

}
