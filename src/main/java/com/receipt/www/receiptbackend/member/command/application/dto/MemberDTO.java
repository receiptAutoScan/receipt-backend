package com.receipt.www.receiptbackend.member.command.application.dto;

import java.time.LocalDateTime;

public class MemberDTO {

    private int memberNum;
    private String memberName;
    private String socialLogin;
    private long socialId;
    private String accessToken;
    private long accessTokenExpireDate;
    private String refreshToken;
    private long refreshTokenExpireDate;
    private LocalDateTime signUpDate;
    private String memberId;
    private String memberPwd;
    private String joinDate;

    public MemberDTO() {}

    public MemberDTO(int memberNum, String memberName, String socialLogin, long socialId, String accessToken, long accessTokenExpireDate, String refreshToken, long refreshTokenExpireDate, LocalDateTime signUpDate, String memberId, String memberPwd, String joinDate) {
        this.memberNum = memberNum;
        this.memberName = memberName;
        this.socialLogin = socialLogin;
        this.socialId = socialId;
        this.accessToken = accessToken;
        this.accessTokenExpireDate = accessTokenExpireDate;
        this.refreshToken = refreshToken;
        this.refreshTokenExpireDate = refreshTokenExpireDate;
        this.signUpDate = signUpDate;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.joinDate = joinDate;
    }

    public int getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getSocialLogin() {
        return socialLogin;
    }

    public void setSocialLogin(String socialLogin) {
        this.socialLogin = socialLogin;
    }

    public long getSocialId() {
        return socialId;
    }

    public void setSocialId(long socialId) {
        this.socialId = socialId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getAccessTokenExpireDate() {
        return accessTokenExpireDate;
    }

    public void setAccessTokenExpireDate(long accessTokenExpireDate) {
        this.accessTokenExpireDate = accessTokenExpireDate;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public long getRefreshTokenExpireDate() {
        return refreshTokenExpireDate;
    }

    public void setRefreshTokenExpireDate(long refreshTokenExpireDate) {
        this.refreshTokenExpireDate = refreshTokenExpireDate;
    }

    public LocalDateTime getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(LocalDateTime signUpDate) {
        this.signUpDate = signUpDate;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPwd() {
        return memberPwd;
    }

    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberNum=" + memberNum +
                ", memberName='" + memberName + '\'' +
                ", socialLogin='" + socialLogin + '\'' +
                ", socialId=" + socialId +
                ", accessToken='" + accessToken + '\'' +
                ", accessTokenExpireDate=" + accessTokenExpireDate +
                ", refreshToken='" + refreshToken + '\'' +
                ", refreshTokenExpireDate=" + refreshTokenExpireDate +
                ", signUpDate=" + signUpDate +
                ", memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", joinDate='" + joinDate + '\'' +
                '}';
    }
}

