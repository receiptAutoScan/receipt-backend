package com.receipt.www.receiptbackend.login.command.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.receipt.www.receiptbackend.jwt.TokenProvider;
import com.receipt.www.receiptbackend.login.command.application.dto.AccessTokenDTO;
import com.receipt.www.receiptbackend.login.command.application.dto.KakaoProfileDTO;
import com.receipt.www.receiptbackend.login.command.application.dto.OauthTokenDTO;
import com.receipt.www.receiptbackend.login.command.application.dto.RenewTokenDTO;
import com.receipt.www.receiptbackend.login.command.infra.repository.LoginRepository;
import com.receipt.www.receiptbackend.member.command.application.dto.MemberDTO;
import com.receipt.www.receiptbackend.member.command.application.service.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class LoginService {

    private final LoginRepository loginRepository;
    private final ModelMapper modelMapper;
    private final MemberService memberService;
    private final TokenProvider tokenProvider;

    @Autowired
    public LoginService(LoginRepository loginRepository, ModelMapper modelMapper, MemberService memberService, TokenProvider tokenProvider) {
        this.loginRepository = loginRepository;
        this.modelMapper = modelMapper;
        this.memberService = memberService;
        this.tokenProvider = tokenProvider;
    }

    public OauthTokenDTO getAccessToken(String code) {

        RestTemplate rt = new RestTemplate();
        rt.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www.form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", "a827fafef171f8ca2395cb11a60e3998");
        params.add("redirect_uri", "http://localhost:8080/auth/kakao/callback");
        params.add("code", code);

        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest =
                new HttpEntity<>(params, headers);

        ResponseEntity<String> accessTokenResponse = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        ObjectMapper objectMapper = new ObjectMapper();
        OauthTokenDTO oauthToken = null;

        try {
            oauthToken = objectMapper.readValue(accessTokenResponse.getBody(), OauthTokenDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return oauthToken;
    }

    public AccessTokenDTO getJwtToken(OauthTokenDTO oauthToken) {

        KakaoProfileDTO kakaoProfileDTO = findKakaoProfile(oauthToken.getAccess_token());

        MemberDTO foundmember = new MemberDTO();

        if (memberService.findBySocialId("KAKAO", kakaoProfileDTO.getId()) == null) {

            MemberDTO newMember = new MemberDTO();

            newMember.setSocialLogin("KAKAO");
            newMember.setSocialId(kakaoProfileDTO.getId());
            newMember.setRefreshToken(oauthToken.getRefresh_token());
            newMember.setAccessToken(oauthToken.getAccess_token());
            newMember.setSignUpDate(LocalDateTime.now());
            newMember.setRefreshTokenExpireDate(oauthToken.getRefresh_token_expires_in() + System.currentTimeMillis());
            newMember.setAccessTokenExpireDate(oauthToken.getExpires_in() + System.currentTimeMillis());

            memberService.registNewUser(newMember);
        }

        foundmember = memberService.findBySocialId("KAKAO", kakaoProfileDTO.getId());

        Date accessExpireDate = new Date(foundmember.getAccessTokenExpireDate());

        int memberNum = foundmember.getMemberNum();

        if (accessExpireDate.before(new Date())) {
            RenewTokenDTO renewedToken = renewKakaoToken(foundmember);

            if(renewedToken.getRefresh_token() != null) {

                foundmember.setRefreshToken(renewedToken.getRefresh_token());
                foundmember.setAccessTokenExpireDate(renewedToken.getRefresh_token_expires_in());
            }

            foundmember.setAccessToken(renewedToken.getAccess_token());
            foundmember.setAccessTokenExpireDate(renewedToken.getRefresh_token_expires_in() + System.currentTimeMillis());
        }

        return tokenProvider.generateMemberTokenDTO(foundmember, memberNum);
    }

    private RenewTokenDTO renewKakaoToken(MemberDTO foundmember) {

        RestTemplate rt = new RestTemplate();
        rt.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "refresh_token");
        params.add("client_id", "a827fafef171f8ca2395cb11a60e3998");
        params.add("refresh_token", foundmember.getRefreshToken());

        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest =
                new HttpEntity<>(params, headers);

        ResponseEntity<String> renewTokenResponse = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        ObjectMapper objectMapper = new ObjectMapper();
        RenewTokenDTO renewToken = null;

        try {
            renewToken = objectMapper.readValue(renewTokenResponse.getBody(), RenewTokenDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return renewToken;
    }

    private KakaoProfileDTO findKakaoProfile(String accessToken) {

        RestTemplate rt = new RestTemplate();
        rt.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

        HttpHeaders headers = new HttpHeaders();
        headers.add("authorization", "Bearer" + accessToken);
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest =
                new HttpEntity<>(headers);

        ResponseEntity<String> kakaoProfileResponse = rt.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoProfileRequest,
                String.class
        );

        KakaoProfileDTO kakaoProfileDTO = new KakaoProfileDTO();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            kakaoProfileDTO = objectMapper.readValue(kakaoProfileResponse.getBody(),
                    KakaoProfileDTO.class);
        } catch(JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return kakaoProfileDTO;
    }
}
