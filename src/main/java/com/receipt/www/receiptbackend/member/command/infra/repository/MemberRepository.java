package com.receipt.www.receiptbackend.member.command.infra.repository;

import com.receipt.www.receiptbackend.member.command.domain.aggregate.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findBySocialId(String socialLogin, long socialid);

    Member findByMemberNum(int memberNum);


}
