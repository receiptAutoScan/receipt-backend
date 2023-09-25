package com.receipt.www.receiptbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//public class CorsConfiguration {
//
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("http://localhost:3000", "http://localhost:3001", "http://localhost:8080")
//                        .allowedMethods("GET", "PUT", "POST", "DELETE", "OPTIONS")
//                        .allowedHeaders("*");
//
//            }
//        };
//    }
//}

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

//    @Value("${spring.servlet.multipart.location}")
//    private String UPLOAD_IMAGE_PATH;
//    @Value("${image.add-resource-locations}")
//    private String ADD_RESOURCE_LOCATION;
//
//    @Value("${image.add-resource-handler}")
//    private String ADD_RESOURCE_HANDLER;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedHeaders("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
