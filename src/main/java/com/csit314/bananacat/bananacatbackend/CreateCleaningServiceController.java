package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CreateCleaningServiceController {

    @PostMapping("/CreateCleaningService")
    public boolean CreateCleaningService(@RequestBody CleaningServiceEntity CSEntity) {
        return CSEntity.CreateCleaningService();
    }
    
}
