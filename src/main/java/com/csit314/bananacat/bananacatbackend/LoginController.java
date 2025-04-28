package com.csit314.bananacat.bananacatbackend;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpSession;

@RestController
public class LoginController {

    private final UserAccountRepository usersrepository;
    private HttpSession session;
    private final PasswordEncoder passwordEncoder;

    public LoginController (UserAccountRepository usersrepository, PasswordEncoder passwordEncoder) {
        this.usersrepository = usersrepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/api/auth/login")//need to change path
    public ResponseEntity<?> Login(@RequestBody UserAccountEntity loginEntity, HttpSession session) {
        return (loginEntity.Login(usersrepository, this.session, passwordEncoder));
    }
}
