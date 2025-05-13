package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ViewShortlistController {
    @PostMapping("/ViewShortlist")
    public ResponseEntity<?> ViewShortlist(@RequestBody shortlistEntity slEntity) {
        return slEntity.ViewShortlist();
    }
    
}
