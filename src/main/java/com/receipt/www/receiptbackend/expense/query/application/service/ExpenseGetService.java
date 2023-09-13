package com.receipt.www.receiptbackend.expense.query.application.service;

import com.receipt.www.receiptbackend.expense.command.domain.aggregate.entity.ExpenseEntity;
import com.receipt.www.receiptbackend.expense.query.infra.mapper.ExpenseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseGetService {

    private final ExpenseMapper expenseMapper;

    public ExpenseGetService(ExpenseMapper expenseMapper) {
        this.expenseMapper = expenseMapper;
    }

    public List<ExpenseEntity> getAllExpenses() {
        return expenseMapper.getAllExpenses();
    }
}
