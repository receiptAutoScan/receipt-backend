package com.receipt.www.receiptbackend.revenue.command.application.service;


import com.receipt.www.receiptbackend.expense.command.application.dto.CreateExpenseDTO;
import com.receipt.www.receiptbackend.expense.command.application.dto.UpdateExpenseDTO;
import com.receipt.www.receiptbackend.expense.command.domain.aggregate.entity.ExpenseEntity;
import com.receipt.www.receiptbackend.revenue.command.application.dto.RevenueDTO;
import com.receipt.www.receiptbackend.revenue.command.domain.aggregate.entity.RevenueEntity;
import com.receipt.www.receiptbackend.revenue.command.infra.repository.RevenueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RevenueService {
    RevenueMapper revenueMapper;

    @Autowired
    public RevenueService(RevenueMapper revenueMapper){
        this.revenueMapper = revenueMapper;
    }
    @Transactional
    public void uploadExcel(List<RevenueDTO> excelFile) {

        for (RevenueDTO revenueDTO : excelFile) {

            RevenueEntity revenueEntity = new RevenueEntity(revenueDTO);

            revenueMapper.save(revenueEntity);
        }
    }

    @Transactional
    public void deleteExcel(Long revenueNum) {

        revenueMapper.deleteById(revenueNum);
    }
}
