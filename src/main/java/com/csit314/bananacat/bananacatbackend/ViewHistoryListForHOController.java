package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ViewHistoryListForHOController {
    @PostMapping("path")
    public ResponseEntity<?> ViewHistoryListForHO(@RequestBody HistoryEntity hEntity) {
        return hEntity.ViewHistoryListForHO();
    }
    
}
