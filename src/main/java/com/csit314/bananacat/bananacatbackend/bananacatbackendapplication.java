package com.csit314.bananacat.bananacatbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication(scanBasePackages = "com.csit314.bananacat.bananacatbackend")
@EnableJpaRepositories(basePackages = "com.csit314.bananacat.bananacatbackend")
@EntityScan(basePackages = "com.csit314.bananacat.bananacatbackend")
public class bananacatbackendapplication {
    public static void main(String[] args) {
        SpringApplication.run(bananacatbackendapplication.class, args);
    }
}
// This is the main class for the Spring Boot application. It uses the @SpringBootApplication annotation to enable auto-configuration, component scanning, and configuration properties scanning. The main method runs the application.