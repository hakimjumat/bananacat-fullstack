package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

@RestController
public class SearchUserProfileController {

    @PostMapping("/searchP")
    public ResponseEntity<?> SearchUserProfile(@RequestBody UserProfileEntity searchentity) {
        return (searchentity.SearchUserProfile());
    }
    
}
