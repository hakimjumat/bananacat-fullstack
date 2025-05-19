package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class SuspendUserAccountController {
    
    @PostMapping("/suspend")
    public boolean SuspendUserAccount(@RequestBody UserAccountEntity suspendEntity) {
        return (suspendEntity.SuspendUserAccount());
    }
}
