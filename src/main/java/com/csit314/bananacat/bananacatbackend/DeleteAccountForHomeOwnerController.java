package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class DeleteAccountForHomeOwnerController {
    @PostMapping("/DeleteHomeOwner")
    public boolean DeleteAccoontForHomeOwner(@RequestBody UserAccountEntity UAentity) {
        return UAentity.DeleteAccountForHomeOwner();
    }
    
}
