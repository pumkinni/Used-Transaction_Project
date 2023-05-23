package com.example.usedtransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@EnableFeignClients
@SpringBootApplication
public class UsedTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsedTransactionApplication.class, args);
    }

}
