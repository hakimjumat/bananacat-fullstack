package com.csit314.bananacat.bananacatbackend;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteCategoryController {

    @Autowired
    private CategoryRepository cRepository;

    @PostMapping("/DeleteCategory")
    public boolean deleteCategory(@RequestBody CategoryEntity cEntity) {
        Optional<CategoryEntity> result = cRepository.findByName(cEntity.getName());
        if (result.isPresent()) {
            cRepository.deleteById(result.get().getId());
            return true;
        } else {
            return false;
        }
    }
}