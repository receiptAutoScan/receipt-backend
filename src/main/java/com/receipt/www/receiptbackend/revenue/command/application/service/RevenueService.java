package com.receipt.www.receiptbackend.revenue.command.application.service;


import com.receipt.www.receiptbackend.expense.command.domain.aggregate.entity.ExpenseEntity;
import com.receipt.www.receiptbackend.revenue.command.application.dto.RevenueDTO;
import com.receipt.www.receiptbackend.revenue.command.domain.aggregate.entity.RevenueEntity;
import com.receipt.www.receiptbackend.revenue.command.infra.repository.RevenueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
public class RevenueService {
    RevenueMapper revenueMapper;

    @Autowired
    public RevenueService(RevenueMapper revenueMapper){
        this.revenueMapper = revenueMapper;
    }
    @Transactional
    public void uploadExcel(List<Map<String , Object>> excelData) throws ParseException {

        for (int i=0; i<excelData.size()-1; i++){
            RevenueDTO dataToDTO = new RevenueDTO();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.KOREA);
            System.out.println(((String)excelData.get(i).get("년-월")).concat("-01"));
            LocalDate date = LocalDate.parse(((String)excelData.get(i).get("년-월")).concat("-01"),formatter);
            dataToDTO.setRevenueDate(date);
            dataToDTO.setRevenueDay(excelData.get(i).get("영업일수").toString());
            dataToDTO.setRevenueTotal((int)excelData.get(i).get("총매출"));
            dataToDTO.setRevenueSale((int)excelData.get(i).get("총할인"));
            dataToDTO.setRevenueActual((int)excelData.get(i).get("실매출"));
            dataToDTO.setReceiptNum((int)excelData.get(i).get("영수건수"));
            dataToDTO.setReceiptPrice((int)excelData.get(i).get("영수단가"));
            dataToDTO.setReceiptValue((int)excelData.get(i).get("가액"));
            dataToDTO.setSurtax((int)excelData.get(i).get("부가세"));

            RevenueEntity revenueEntity = new RevenueEntity(dataToDTO);

            revenueMapper.save(revenueEntity);
        }
    }

    @Transactional
    public void deleteExcel(Long revenueNum) {

        revenueMapper.deleteById(revenueNum);
    }
}
