package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class DeleteCleaningServiceController {
    private final CleaningServiceRepository CSRepository;

    public DeleteCleaningServiceController (CleaningServiceRepository CSRepository) {
        this.CSRepository = CSRepository;
    }

    @PostMapping("path")
    public boolean DeleteCleaningService(@RequestBody CleaningServiceEntity CSEntity) {
        return CSEntity.DeleteCleaningService(CSRepository);
    }
    
}
