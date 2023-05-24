package com.example.usedtransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableFeignClients
@EnableJpaRepositories
@EnableJpaAuditing
@SpringBootApplication
public class UsedTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsedTransactionApplication.class, args);
    }

}
