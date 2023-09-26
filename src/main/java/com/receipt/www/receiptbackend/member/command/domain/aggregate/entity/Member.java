package com.receipt.www.receiptbackend.member.command.domain.aggregate.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Member")
@Table(name = "MEMBER")
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "SEQ_MEMBER_NUM",
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

    @Column(name = "MEMBER_NICKNAME")
    private String memberNickname;

    @Column(name = "SOCIAL_LOGIN")
    private String socialLogin;

    @Column(name = "SOCIAL_ID")
    private String socialId;

    @Column(name = "ACCESS_TOKEN")
    private String accessToken;

    @Column(name = "ACCESS_TOKEN_EXPIRE_DATE")
    private long accessTokenExpireDate;

    @Column(name = "REFRESH_TOKEN")
    private String refreshToken;

    @Column(name = "REFRESH_TOKEN_EXPIRE_DATE")
    private long refreshTokenExpireDate;

    @CreatedDate
    @Column(name ="JOIN_DATE")
    private String joinDate;



    @PrePersist
    public void onPrePersist() {
        this.joinDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }


}
