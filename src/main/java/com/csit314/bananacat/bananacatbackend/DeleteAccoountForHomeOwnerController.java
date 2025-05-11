package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class DeleteAccoountForHomeOwnerController {
    @PostMapping("path")
    public boolean DeleteAccoountForHomeOwner(@RequestBody UserAccountEntity UAentity) {
        return UAentity.DeleteAccoountForHomeOwner();
    }
    
}
