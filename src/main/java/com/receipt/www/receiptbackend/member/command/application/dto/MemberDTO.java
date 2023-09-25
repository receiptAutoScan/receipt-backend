package com.receipt.www.receiptbackend.member.command.application.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDTO {

    private int memberNum;
    private String memberName;
    private String socialLogin;
    private String socialId;
    private String accessToken;
    private long accessTokenExpireDate;
    private String refreshToken;
    private long refreshTokenExpireDate;
    private LocalDateTime signUpDate;
    private String memberId;
    private String memberPwd;
    private String joinDate;


}

