package com.receipt.www.receiptbackend.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.receipt.www.receiptbackend")
@EnableJpaRepositories(basePackages = "com.receipt.www.receiptbackend")
public class JPAConfiguration {
}
