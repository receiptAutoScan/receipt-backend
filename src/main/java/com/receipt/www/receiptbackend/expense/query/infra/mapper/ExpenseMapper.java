package com.receipt.www.receiptbackend.expense.query.infra.mapper;

import com.receipt.www.receiptbackend.expense.command.domain.aggregate.entity.ExpenseEntity;
import com.receipt.www.receiptbackend.expense.query.application.dto.ExpenseMonthlyDTO;
import com.receipt.www.receiptbackend.expense.query.application.dto.ProfitDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExpenseMapper {

    List<ExpenseEntity> getAllExpenses();
    List<ExpenseMonthlyDTO> getMonthlyExpenses();

    List<ProfitDTO> getProfit();
}
