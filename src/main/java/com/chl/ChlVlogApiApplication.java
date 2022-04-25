package com.chl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chl.mapper")
public class ChlVlogApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChlVlogApiApplication.class, args);
    }

}
