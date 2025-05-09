package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ViewCleaningServiceListController {
    private final CleaningServiceRepository CSRepository;

    public ViewCleaningServiceListController(CleaningServiceRepository CSRepository) {
        this.CSRepository = CSRepository;
    }

    @PostMapping("path")
    public ResponseEntity<?> ViewCleaningServiceList(@RequestBody CleaningServiceEntity CSEntity) {
        return CSEntity.ViewCleaningServiceList(CSRepository);
    }
    
}
