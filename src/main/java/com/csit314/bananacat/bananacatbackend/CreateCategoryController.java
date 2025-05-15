package com.csit314.bananacat.bananacatbackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class CreateCategoryController {
    @PostMapping("/CreateCategory")
    public boolean CreateCategory(@RequestBody CategoryEntity cEntity) {
        return cEntity.CreateCategory();
    }
    
}
