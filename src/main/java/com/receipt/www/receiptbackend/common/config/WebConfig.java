package com.receipt.www.receiptbackend.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**") // CORS를 적용할 URL패턴 정의
                .allowedOrigins("*") // 자원 공유를 허락할 Origin 지정
                .allowedMethods("GET", "POST", "PUT", "DELETE"); // 허용할 HTTP method 지정
    }
}