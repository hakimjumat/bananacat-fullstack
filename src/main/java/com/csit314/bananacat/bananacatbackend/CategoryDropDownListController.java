package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//for cleaner creating cleaning service, this method will run on webpage load, to retrieve all the category from db
@RestController
public class CategoryDropDownListController {
    @PostMapping("/categorydropdownlist")
    public ResponseEntity<?> CategoryDropDownList(@RequestBody CategoryEntity cEntity) {
        return cEntity.CategoryDropDownList();
    }
    
}
