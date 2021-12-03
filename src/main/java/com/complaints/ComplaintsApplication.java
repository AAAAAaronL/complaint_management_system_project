package com.complaints;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.complaints.mapper")
public class ComplaintsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComplaintsApplication.class, args);
    }

}
