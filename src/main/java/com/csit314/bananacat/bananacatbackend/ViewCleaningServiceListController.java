package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
<<<<<<< HEAD:src/main/java/com/csit314/bananacat/bananacatbackend/NumberofPageViewsController.java
public class NumberofPageViewsController {
    @PostMapping("/NumberofPageViews")
    public ResponseEntity<?> NumberofPageViews(@RequestBody UserAccountEntity UAentity) {
        return UAentity.NumberofPageViews();
=======
public class ViewCleaningServiceListController {
    @PostMapping("path")
    public ResponseEntity<?> ViewCleaningServiceList(@RequestBody CleaningServiceEntity csEntity) {
        return csEntity.ViewCleaningServiceList();
>>>>>>> 5a343512a00de7c38af8be16728cda8abc809fc0:src/main/java/com/csit314/bananacat/bananacatbackend/ViewCleaningServiceListController.java
    }
    
}
