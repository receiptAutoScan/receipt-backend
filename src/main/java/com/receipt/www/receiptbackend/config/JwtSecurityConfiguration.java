package com.receipt.www.receiptbackend.config;

import com.receipt.www.receiptbackend.jwt.JwtFilter;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.receipt.www.receiptbackend.jwt.TokenProvider;

public class JwtSecurityConfiguration extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final TokenProvider tokenProvider;

    public JwtSecurityConfiguration(TokenProvider tokenProvider) {

        this.tokenProvider = tokenProvider;
    }

    @Override
    public void configure(HttpSecurity http) {

        JwtFilter customFilter = new JwtFilter(tokenProvider);

        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }


}
