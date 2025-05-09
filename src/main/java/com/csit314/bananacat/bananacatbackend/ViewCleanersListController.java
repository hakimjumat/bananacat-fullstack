package com.csit314.bananacat.bananacatbackend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ViewCleanersListController {
    @PostMapping("path")
    public ResponseEntity<?> ViewCleanersList(@RequestBody UserAccountEntity UAentity) {
        return UAentity.ViewCleanersList();
    }
}
