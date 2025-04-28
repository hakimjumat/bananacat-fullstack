package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ViewUserAccountController {

    private final UserAccountRepository usersrepository;

    public ViewUserAccountController (UserAccountRepository usersrepository) {
        this.usersrepository = usersrepository;
    }

    @PostMapping("/view")
    public ResponseEntity<?> ViewUserAccount(@RequestBody UserAccountEntity viewuser) {
        return (viewuser.ViewUserAccount(usersrepository));
    }
}
