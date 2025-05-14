package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class WeeklyReportController {
    @PostMapping("path")
    public ResponseEntity<?> WeeklyReport(@RequestBody HistoryEntity hEntity) {
        return hEntity.WeeklyReport();
    }
    
}
