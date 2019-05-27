package com.picea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SpringBootInheritablethreadlocalApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootInheritablethreadlocalApplication.class, args);
    }

}
