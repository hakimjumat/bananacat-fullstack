package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

@RestController
public class UpdateCleaningServiceController {
    private final CleaningServiceRepository CSRepository;

    public UpdateCleaningServiceController(CleaningServiceRepository CSRepository) {
        this.CSRepository = CSRepository;
    }

    @PostMapping("path")
    public ResponseEntity<?> postMethodName(@RequestBody CleaningServiceEntity CSEntity) {
        return CSEntity.UpdateCleaningService(CSRepository);
    }
    
}
