package com.receipt.www.receiptbackend.member.command.application.service;

import com.receipt.www.receiptbackend.member.command.application.dto.MemberDTO;
import com.receipt.www.receiptbackend.member.command.domain.aggregate.entity.Member;
import com.receipt.www.receiptbackend.member.command.infra.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MemberService(MemberRepository memberRepository, ModelMapper modelMapper) {
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;

    }
    public MemberDTO findBySocialId(String socialLogin, long socialId) {

        Member foundMember = memberRepository.findBySocialId(socialLogin, socialId);

        if (foundMember == null) {
            return null;
        } else {
            return modelMapper.map(foundMember, MemberDTO.class);
        }
    }

    @Transactional
    public Long registNewUser(MemberDTO newMember) {

        newMember.setMemberName("새로운회원" +(Math.random() * 100 + 1));

        return memberRepository.save(modelMapper.map(newMember, Member.class)).getMemberNum();
    }
}
