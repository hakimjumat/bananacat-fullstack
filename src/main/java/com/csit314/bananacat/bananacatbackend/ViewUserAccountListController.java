package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ViewUserAccountListController {

    private final UserAccountRepository usersrepository;

    public ViewUserAccountListController (UserAccountRepository usersrepository) {
        this.usersrepository = usersrepository;
    }

    @PostMapping("/v")
    public ResponseEntity<?> ViewUserAccountList(@RequestBody UserAccountEntity viewuserlist) {
        return (viewuserlist.ViewUserAccountList(usersrepository));
    }
}
