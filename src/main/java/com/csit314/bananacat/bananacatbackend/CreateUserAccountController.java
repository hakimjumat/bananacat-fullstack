package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class CreateUserAccountController {

    private final PasswordEncoder passwordEncoder;

    public CreateUserAccountController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/api/create")
    public boolean CreateUserAccount(@RequestBody UserAccountEntity createaccount) {
        return createaccount.CreateUserAccount(passwordEncoder); 
    }
}
