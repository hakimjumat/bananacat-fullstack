package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class CreateUserAccountController {
    @Autowired
    private final UserService userservice;

    public CreateUserAccountController(UserService userservice) {
        this.userservice = userservice;
    }

    public boolean create(@RequestBody CreateAccountDTO createaccountDTO) {

        return (userservice.create(createaccountDTO.getEmail(), createaccountDTO.getPassword(), createaccountDTO.getUserprofile(), createaccountDTO.getFirstname(), createaccountDTO.getLastname(), createaccountDTO.getPhonenumber(), createaccountDTO.getAddress()));
    }
}
