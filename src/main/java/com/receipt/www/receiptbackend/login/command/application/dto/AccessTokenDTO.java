package com.receipt.www.receiptbackend.login.command.application.dto;

public class AccessTokenDTO {

    private String grantType;
    private long memberId;
    private String accessToken;
    private long accessTokenExpires_in;

    public AccessTokenDTO() {}

    public AccessTokenDTO(String grantType, long memberNum, String accessToken, long accessTokenExpires_in) {
        this.grantType = grantType;
        this.memberId = memberNum;
        this.accessToken = accessToken;
        this.accessTokenExpires_in = accessTokenExpires_in;
    }


    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public long getMemberId() { return memberId; }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getAccessTokenExpires_in() {
        return accessTokenExpires_in;
    }

    public void setAccessTokenExpires_in(long accessTokenExpriesIn) {
        this.accessTokenExpires_in = accessTokenExpriesIn;
    }

    @Override
    public String toString() {
        return "AccessTokenDTO{" +
                "grantType='" + grantType + '\'' +
                ", memberId=" + memberId +
                ", accessToken='" + accessToken + '\'' +
                ", accessTokenExpires_in=" + accessTokenExpires_in +
                '}';
    }
}