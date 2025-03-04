package com.venepiano;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.venepiano.repository.mapper")
public class ModuleOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleOrderApplication.class, args);
    }

}
