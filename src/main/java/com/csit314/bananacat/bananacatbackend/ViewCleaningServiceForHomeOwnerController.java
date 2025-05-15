package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ViewCleaningServiceForHomeOwnerController {
        private final CleaningServiceRepository CSRepository;

        public ViewCleaningServiceForHomeOwnerController(CleaningServiceRepository CSRepository) {
            this.CSRepository = CSRepository;
        }

        @PostMapping("/viewCleaningServiceForHomeOwner")
        public ResponseEntity<?> ViewCleaningServiceforHomeOwner(@RequestBody CleaningServiceEntity CSEntity) {
            return CSEntity.ViewCleaningServiceforHomeOwner(CSRepository);
        }
        
}
