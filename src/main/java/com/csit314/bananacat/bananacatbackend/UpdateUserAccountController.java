package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.crypto.password.PasswordEncoder;


@RestController
public class UpdateUserAccountController {

    private final PasswordEncoder passwordEncoder;

    public UpdateUserAccountController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/update")
    public ResponseEntity<?> UpdateUserAccount(@RequestBody UserAccountEntity updatedUser) {
        return updatedUser.UpdateUserAccount(passwordEncoder);
    }
}
