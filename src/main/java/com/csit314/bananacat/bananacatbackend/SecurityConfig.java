package com.csit314.bananacat.bananacatbackend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //     http
    //         .authorizeHttpRequests(auth -> auth
    //             .requestMatchers("/public/**").permitAll()   // allow public access
    //             .anyRequest().authenticated()               // everything else needs login
    //         )
    //         .formLogin(form -> form
    //             .loginPage("/login")  // your custom login page
    //             .permitAll()
    //         )
    //         .logout(logout -> logout.permitAll());

    //     return http.build();
    // }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}