package com.receipt.www.receiptbackend.login.command.infra.repository;

import com.receipt.www.receiptbackend.member.command.domain.aggregate.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoginRepository extends JpaRepository<Member, Long> {
}
