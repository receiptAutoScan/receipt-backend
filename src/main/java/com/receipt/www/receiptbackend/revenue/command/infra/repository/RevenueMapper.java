package com.receipt.www.receiptbackend.revenue.command.infra.repository;


import com.receipt.www.receiptbackend.revenue.command.domain.aggregate.entity.RevenueEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RevenueMapper extends JpaRepository<RevenueEntity,Long> {

}
