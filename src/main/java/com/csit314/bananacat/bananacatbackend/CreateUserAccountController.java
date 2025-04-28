package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class CreateUserAccountController {

    private final UserAccountRepository usersrepository;
    private final PasswordEncoder passwordEncoder;

    public CreateUserAccountController(UserAccountRepository usersrepository, PasswordEncoder passwordEncoder) {
        this.usersrepository = usersrepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/create")
    public boolean CreateUserAccount(@RequestBody UserAccountEntity createaccount) {
        return createaccount.CreateUserAccount(usersrepository, passwordEncoder); 
    }
}
