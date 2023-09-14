package com.receipt.www.receiptbackend.login.command.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class KakaoProfileDTO {

    private long id;
    private String connected_at;
    private KakaoAccount kakao_account;
    private Properties properties;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class KakaoAccount {
        private boolean has_email;
        private boolean email_needs_agreement;
        private boolean is_email_valid;
        private boolean is_email_verified;
        private String email;
        private boolean profile_nickname_needs_agreement;
        private Profile profile;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class Properties {
        private String nickname;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class Profile {
        private String nickname;
    }
}
