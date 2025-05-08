package com.csit314.bananacat.bananacatbackend;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class LoginController {

    private final PasswordEncoder passwordEncoder;

    public LoginController (PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/api/auth/login")
    public ResponseEntity<?> Login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");
        return UserAccountEntity.login(passwordEncoder, email, password);
    }
}
