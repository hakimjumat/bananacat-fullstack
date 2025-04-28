package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UpdateUserProfileController {
    
    private final UserProfileRepository profilerepository;

    public UpdateUserProfileController (UserProfileRepository profilerepository) {
        this.profilerepository = profilerepository;
    }

    @PostMapping("/updateP")
    public ResponseEntity<?> UpdateUserProfile(@RequestBody UserProfileEntity updateentity) {
        try{
            return updateentity.UpdateUserProfile(profilerepository);
        } catch (IllegalAccessException e) {
            return ResponseEntity.ok("Update Error");
        }
    }
}
