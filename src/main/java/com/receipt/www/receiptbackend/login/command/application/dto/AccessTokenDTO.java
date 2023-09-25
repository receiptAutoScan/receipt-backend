package com.receipt.www.receiptbackend.login.command.application.dto;

public class AccessTokenDTO {

    private String grantType;
    private long memberId;
    private String accessToken;
    private long accessTokenExpriesIn;

    public AccessTokenDTO() {}

    public AccessTokenDTO(String grantType, long memberNum, String accessToken, long accessTokenExpriesIn) {
        this.grantType = grantType;
        this.memberId = memberNum;
        this.accessToken = accessToken;
        this.accessTokenExpriesIn = accessTokenExpriesIn;
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

    public long getAccessTokenExpriesIn() {
        return accessTokenExpriesIn;
    }

    public void setAccessTokenExpriesIn(long accessTokenExpriesIn) {
        this.accessTokenExpriesIn = accessTokenExpriesIn;
    }

    @Override
    public String toString() {
        return "AccessTokenDTO{" +
                "grantType='" + grantType + '\'' +
                ", memberId=" + memberId +
                ", accessToken='" + accessToken + '\'' +
                ", accessTokenExpriesIn=" + accessTokenExpriesIn +
                '}';
    }
}