package com.receipt.www.receiptbackend.expense.query.infra.mapper;

import com.receipt.www.receiptbackend.expense.command.domain.aggregate.entity.ExpenseEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExpenseMapper {

    List<ExpenseEntity> getAllExpenses();
}
