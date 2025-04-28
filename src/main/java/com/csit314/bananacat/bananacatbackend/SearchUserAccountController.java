package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;


@RestController
public class SearchUserAccountController {

    private final UserAccountRepository usersrepository;

    public SearchUserAccountController(UserAccountRepository usersrepository) {
        this.usersrepository = usersrepository;
    }

    @PostMapping("path")
    public ResponseEntity<?> SearchUserAccount(@RequestBody UserAccountEntity searchUser) {
        return (searchUser.SearchUserAccount(usersrepository));
    }
}
