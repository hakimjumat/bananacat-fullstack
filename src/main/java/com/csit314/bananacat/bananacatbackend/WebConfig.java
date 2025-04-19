package com.csit314.bananacat.bananacatbackend;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;




@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Allow all endpoints
                        .allowedOrigins("http://127.0.0.1:5500", "http://localhost:5500") // Your frontend URLs
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Methods to allow
                        .allowedHeaders("*") // Allow all headers
                        .allowCredentials(true); // Allow cookies/authorization headers if needed
            }
        };
    }
}
// This configuration class sets up CORS (Cross-Origin Resource Sharing) for the Spring Boot application. It allows requests from specified origins (in this case, the frontend URLs) and specifies which HTTP methods and headers are allowed. The allowCredentials(true) setting allows cookies and authorization headers to be included in cross-origin requests.

