package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

@RestController
public class ViewUserProfileController {

    private final UserProfileRepository profilerepository;

    public ViewUserProfileController (UserProfileRepository profilerepository) {
        this.profilerepository = profilerepository;
    }

    @PostMapping("/viewP")
    public ResponseEntity<?> ViewUserProfile(@RequestBody UserProfileEntity viewProfile) {
        return viewProfile.ViewUserProfile(profilerepository);
    }
}

