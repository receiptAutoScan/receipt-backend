package com.receipt.www.receiptbackend.revenue.query.application.service;

import com.receipt.www.receiptbackend.revenue.command.application.dto.RevenueDTO;

import com.receipt.www.receiptbackend.revenue.command.application.dto.RevenueMonYearDTO;
import com.receipt.www.receiptbackend.revenue.command.domain.aggregate.entity.RevenueEntity;
import com.receipt.www.receiptbackend.revenue.query.infra.mapper.RevenueMapper;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;



@Service
public class RevenueGetService {
    RevenueMapper revenueMapper;

    public RevenueGetService(RevenueMapper revenueMapper) {
        this.revenueMapper = revenueMapper;
    }

    public List<RevenueDTO> inquireExcelByDay() throws ParseException {
        List<RevenueEntity> revenueEntities = revenueMapper.getAllRevenues();
        List<RevenueDTO> revenueDTOList = new ArrayList<>();

        for(RevenueEntity revenueEntity : revenueEntities){
            revenueDTOList.add(new RevenueDTO(
                    revenueEntity.getRevenueDate(),
                    revenueEntity.getRevenuePoint(),
                    revenueEntity.getRevenueType(),
                    revenueEntity.getRevenuePrice()
            ));
        }
        return revenueDTOList;
    }

    public List<RevenueMonYearDTO> inquireExcelByMonth() {
        return revenueMapper.getAllRevenuesByMonth();
    }

    public List<RevenueMonYearDTO> inquireExcelByYear() throws ParseException {
        return revenueMapper.getAllRevenuesByYear();
    }

}
