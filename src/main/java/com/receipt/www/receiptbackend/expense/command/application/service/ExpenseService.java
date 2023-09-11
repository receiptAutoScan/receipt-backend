package com.receipt.www.receiptbackend.expense.command.application.service;

import com.receipt.www.receiptbackend.expense.command.application.dto.CreateExpenseDTO;
import com.receipt.www.receiptbackend.expense.command.application.dto.UpdateExpenseDTO;
import com.receipt.www.receiptbackend.expense.command.domain.aggregate.entity.ExpenseEntity;
import com.receipt.www.receiptbackend.expense.command.infra.repository.ExpenseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Transactional
    public void createExpenseList(List<CreateExpenseDTO> createExpenseDTOList) {

        for (CreateExpenseDTO createExpenseDTO : createExpenseDTOList) {

            ExpenseEntity expenseEntity = new ExpenseEntity(createExpenseDTO);

            expenseRepository.save(expenseEntity);
        }
    }

    @Transactional
    public void updateExpense(UpdateExpenseDTO updateExpenseDTO) {

        expenseRepository.getReferenceById(updateExpenseDTO.getExpenseId());

        ExpenseEntity expenseEntity = new ExpenseEntity(updateExpenseDTO);

        expenseRepository.save(expenseEntity);
    }

    @Transactional
    public void deleteExpense(Long expenseId) {

        expenseRepository.deleteById(expenseId);
    }

}
