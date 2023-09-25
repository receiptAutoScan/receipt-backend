package com.receipt.www.receiptbackend.member.command.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.receipt.www.receiptbackend.member.command.application.dto.MemberDTO;
import com.receipt.www.receiptbackend.member.command.domain.aggregate.entity.Member;
import com.receipt.www.receiptbackend.member.command.infra.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.Map;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;
    private final ObjectMapper objectMapper;

    @Autowired
    public MemberService(MemberRepository memberRepository, ModelMapper modelMapper, ObjectMapper objectMapper) {
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
        this.objectMapper = objectMapper;

    }
    public MemberDTO findBySocialId(String socialLogin, String socialId) {

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

    public MemberDTO getAuthedMember(String header) throws JsonProcessingException {

        Map<String, String> headerMap = objectMapper.readValue(header, Map.class);

        String id = String.valueOf(headerMap.get("memberId"));

        Long memberId = Long.parseLong(id);

        Member authedMember = memberRepository.findById(memberId).get();

        return modelMapper.map(authedMember, MemberDTO.class);
    }


}
