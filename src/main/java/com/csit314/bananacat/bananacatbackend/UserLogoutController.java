package com.csit314.bananacat.bananacatbackend;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/logout")
@CrossOrigin(origins = "*")
public class UserLogoutController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User logout() {
        return userService.logout(); // No parameters here
    }
}

