package com.csit314.bananacat.bananacatbackend;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class LoginController {

    private final UserAccountRepository usersrepository;
    private final PasswordEncoder passwordEncoder;

    public LoginController (UserAccountRepository usersrepository, PasswordEncoder passwordEncoder) {
        this.usersrepository = usersrepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/api/auth/login")
    public ResponseEntity<?> Login(@RequestBody Map<String, String> loginData, HttpSession session) {
        String email = loginData.get("email");
        String password = loginData.get("password");
        return UserAccountEntity.login(usersrepository, session, passwordEncoder, email, password);
    }
}
