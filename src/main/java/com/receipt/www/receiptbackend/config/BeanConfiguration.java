package com.receipt.www.receiptbackend.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.receipt.www.receiptbackend")
public class BeanConfiguration {

    public BeanConfiguration() {}

    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }
}
