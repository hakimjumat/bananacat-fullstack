package com.csit314.bananacat.bananacatbackend;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutController {

    private final UserAccountEntity userEntity; // Create an instance to access Logout method

    public LogoutController() {
        this.userEntity = new UserAccountEntity(); // Simple default constructor
    }

    @PostMapping("/api/auth/logout")
    public ResponseEntity<?> LogoutC(HttpSession session) {
        return userEntity.logout(session);
    }
}