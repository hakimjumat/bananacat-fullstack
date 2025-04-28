package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateUserProfileController {

    private final UserProfileRepository profilerepository;

    public CreateUserProfileController (UserProfileRepository profilerepository) {
        this.profilerepository = profilerepository;
    }

    @PostMapping("/createP")
    public boolean CreateUserProfile(@RequestBody UserProfileEntity createprofile) {
        return createprofile.CreateUserProfile(profilerepository);
    }
}
