package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

@RestController
public class ViewHistoryListController {
    @PostMapping("/ViewHistoryList")
    public ResponseEntity<?> ViewHistoryList(@RequestBody HistoryEntity hEntity) {
        return hEntity.ViewHistoryList();
    }
    
}
