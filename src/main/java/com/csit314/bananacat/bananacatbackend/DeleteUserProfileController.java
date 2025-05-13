package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class DeleteUserProfileController {

    private final UserProfileRepository profilerepository;
    private final UserAccountRepository usersrepository;

    public DeleteUserProfileController (UserProfileRepository profilerepository, UserAccountRepository usersrepository) {
        this.profilerepository = profilerepository;
        this.usersrepository = usersrepository;
    }

    @PostMapping("/deleteUserProfile") 
    public boolean DeleteUserProfile(@RequestBody UserProfileEntity deleteentity) {
        return (deleteentity.DeleteUserProfile(profilerepository, usersrepository));
    }
}
