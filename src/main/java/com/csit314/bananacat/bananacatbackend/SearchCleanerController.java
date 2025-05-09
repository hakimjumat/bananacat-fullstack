package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

@RestController
public class SearchCleanerController {
    @PostMapping("path")
    public ResponseEntity<?> SearchCleaner(@RequestBody UserAccountEntity UAentity) {
        return UAentity.SearchCleaner();
    }
    
}
