package com.receipt.www.receiptbackend.revenue.query.infra.mapper;

import com.receipt.www.receiptbackend.revenue.command.application.dto.RevenueMonYearDTO;
import com.receipt.www.receiptbackend.revenue.command.domain.aggregate.entity.RevenueEntity;
import com.receipt.www.receiptbackend.revenue.query.application.dto.RevenueMonthlyDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RevenueMapper {

    List<RevenueEntity> getAllRevenues();
    List<RevenueMonthlyDTO> getAllRevenuesByMonth();
//    List<RevenueMonYearDTO> getAllRevenuesByYear();
}
