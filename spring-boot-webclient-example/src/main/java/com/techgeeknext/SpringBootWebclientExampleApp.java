package com.techgeeknext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages= {"com.techgeeknext.example.controller"})
@SpringBootApplication
public class SpringBootWebclientExampleApp {
 
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebclientExampleApp.class, args);
    }
} 