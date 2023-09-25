package com.receipt.www.receiptbackend.member.command.application.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.receipt.www.receiptbackend.common.dto.ResponseDTO;
import com.receipt.www.receiptbackend.member.command.application.dto.MemberDTO;
import com.receipt.www.receiptbackend.member.command.application.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.awt.print.Pageable;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json;charset=UTF-8")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/{socialLogin}/{socialId}")
    public ResponseEntity<ResponseDTO> findBySocialId(@PathVariable String socialLogin, @PathVariable String socialId) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        MemberDTO foundMember = memberService.findBySocialId(socialLogin, socialId);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("member", foundMember);

        return ResponseEntity.ok().body(new ResponseDTO(200, "소셜 아이디 검색 성공!", responseMap));
    }

    @GetMapping("/members/auth")
    public ResponseEntity<?> getCurrentMember(HttpServletRequest request)
        throws JsonProcessingException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        MemberDTO currentMember = memberService.getAuthedMember(request.getHeader("Auth"));

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("member", currentMember);

        return ResponseEntity.ok().headers(headers).body(new ResponseDTO(200, "인증 조회 성공", responseMap));
    }

}
