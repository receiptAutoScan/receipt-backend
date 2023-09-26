package com.receipt.www.receiptbackend.revenue.command.application.service;


import com.receipt.www.receiptbackend.revenue.command.application.dto.RevenueDTO;
import com.receipt.www.receiptbackend.revenue.command.domain.aggregate.entity.RevenueEntity;
import com.receipt.www.receiptbackend.revenue.command.infra.repository.RevenueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
public class RevenueService {
    RevenueRepo revenueRepo;

    @Autowired
    public RevenueService(RevenueRepo revenueRepo){
        this.revenueRepo = revenueRepo;
    }
    @Transactional
    public void uploadExcel(List<Map<String , Object>> excelData) throws ParseException {
//        System.out.println(excelData);
        for (int i=0; i<excelData.size()-1; i++){
            RevenueDTO dataToDTO = new RevenueDTO();
            System.out.println(excelData.get(i));
            excelData.get(i).replace(" ","");
            System.out.println(excelData.get(i).get(" 일자 "));
            System.out.println(excelData.get(i).get(" 거래처 "));
            System.out.println(excelData.get(i).get("품목"));
            System.out.println(excelData.get(i).get(" 금액 "));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.KOREA);
            LocalDate date = LocalDate.parse(((String)excelData.get(i).get(" 일자 ")),formatter);
            dataToDTO.setRevenueDate(date);
            dataToDTO.setRevenuePoint((String)excelData.get(i).get(" 거래처 "));
            dataToDTO.setRevenueType((String)excelData.get(i).get("품목"));
            dataToDTO.setRevenuePrice((int)excelData.get(i).get(" 금액 "));

            RevenueEntity revenueEntity = new RevenueEntity(dataToDTO);

            revenueRepo.save(revenueEntity);
        }
    }

    @Transactional
    public void deleteExcel(Long revenueNum) {

        revenueRepo.deleteById(revenueNum);
    }
}
