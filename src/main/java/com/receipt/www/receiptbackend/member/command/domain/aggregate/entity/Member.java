package com.receipt.www.receiptbackend.member.command.domain.aggregate.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity(name = "Member")
@Table(name = "member")
@SequenceGenerator(
        name = "MEMBER_SEQ-GENERATOR",
        sequenceName = "SEQ_MEMBER_CODE",
        initialValue = 1,
        allocationSize = 1
)
public class Member {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GENERATOR"
    )
    @Column(name = "MEMBER_NUM")
    private Long memberNum;

    @Column(name = "MEMBER_NICKNAME", unique = true)
    private String memberNickname;

    @Column(name = "SOCIAL_LOGIN")
    private String socialLogin;

    @Column(name = "SOCIAL_ID")
    private String socialId;

    @Column(name = "ACCESS_TOKEN")
    private String accessToken;

    @Column(name = "REFRESH_TOKEN")
    private String refreshToken;

    @CreatedDate
    @Column(name ="JOIN_DATE")
    private String joinDate;

    @LastModifiedDate
    @Column(name = "LAST_ACCESS_DATE")
    private String lastAccessDate;

    @PrePersist
    public void onPrePersist() {
        this.joinDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-mm-dd"));
        this.lastAccessDate = this.joinDate;
    }

    @PreUpdate
    public void onPreUpdate() {
        this.lastAccessDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyy-MM-dd"));
    }

    public Member() {}

    public Member(Long memberNum, String memberNickname, String socialLogin, String socialId, String accessToken, String refreshToken, String joinDate, String lastAccessDate) {
        this.memberNum = memberNum;
        this.memberNickname = memberNickname;
        this.socialLogin = socialLogin;
        this.socialId = socialId;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.joinDate = joinDate;
        this.lastAccessDate = lastAccessDate;
    }

    public Long getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(Long memberCode) {
        this.memberNum = memberCode;
    }

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    public String getSocialLogin() {
        return socialLogin;
    }

    public void setSocialLogin(String socialLogin) {
        this.socialLogin = socialLogin;
    }

    public String getSocialId() {
        return socialId;
    }

    public void setSocialId(String socialId) {
        this.socialId = socialId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getLastAccessDate() {
        return lastAccessDate;
    }

    public void setLastAccessDate(String lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberNum=" + memberNum +
                ", memberNickname='" + memberNickname + '\'' +
                ", socialLogin='" + socialLogin + '\'' +
                ", socialId='" + socialId + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", joinDate='" + joinDate + '\'' +
                ", lastAccessDate='" + lastAccessDate + '\'' +
                '}';
    }
}
