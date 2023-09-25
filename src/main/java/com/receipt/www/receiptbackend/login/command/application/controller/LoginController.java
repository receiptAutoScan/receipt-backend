package com.receipt.www.receiptbackend.login.command.application.controller;

import com.receipt.www.receiptbackend.common.dto.ResponseDTO;
import com.receipt.www.receiptbackend.login.command.application.dto.AccessTokenDTO;
import com.receipt.www.receiptbackend.login.command.application.dto.OauthTokenDTO;
import com.receipt.www.receiptbackend.login.command.application.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    private final LoginService loginService;


    @Autowired
    public LoginController(LoginService loginService) {

        this.loginService = loginService;
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/kakaocode")
    public ResponseEntity<?> getKakaoCode(@RequestBody Map<String, String> code) {

        OauthTokenDTO oauthToken = loginService.getAccessToken(code.get("code"));

        System.out.println("oauthToken : " + oauthToken.getAccess_token());

        AccessTokenDTO jwtToken = loginService.getJwtToken(oauthToken);


        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("token", jwtToken);

        return ResponseEntity
                .ok()
                .body(new ResponseDTO(200, "로그인 성공", responseMap));
    }

    @PostMapping("/renew")
    public ResponseEntity<?> renewAccessToken(@RequestHeader(value = "Auth") String auth) {

        return null;
    }


}
