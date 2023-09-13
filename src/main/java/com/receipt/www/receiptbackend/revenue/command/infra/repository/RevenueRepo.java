package com.receipt.www.receiptbackend.revenue.command.infra.repository;


import com.receipt.www.receiptbackend.revenue.command.domain.aggregate.entity.RevenueEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RevenueRepo extends JpaRepository<RevenueEntity,Long> {

}
