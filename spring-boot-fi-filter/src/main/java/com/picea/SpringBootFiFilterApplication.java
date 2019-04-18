package com.picea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringBootFiFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFiFilterApplication.class, args);
    }

}
