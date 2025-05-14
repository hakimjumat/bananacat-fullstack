package com.csit314.bananacat.bananacatbackend;

import java.util.Optional;
import org.springframework.http.ResponseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//category is actually the tag variable in cleaning service entity
@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    String name;
    String Description;

    public void setDescription(String description) {
        Description = description;
    }

    //User Story #34
    public boolean CreateCategory() {
        CategoryRepository cRepository = CategoryRepositoryInjector.repo;
        Optional<CategoryEntity> result = cRepository.findByName(this.name);
        if (result.isPresent()) {
            return false;
        } else {
            cRepository.save(this);
            return true;
        }
    }

    //User Story #35
    public ResponseEntity<?> ViewCategory() {
        CategoryRepository cRepository = CategoryRepositoryInjector.repo;
        Optional<CategoryEntity> result = cRepository.findByName(this.name);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.ok("not found");
        }
    }

    //User Story #36
    public ResponseEntity<?> UpdateCategory() {
        CategoryRepository cRepository = CategoryRepositoryInjector.repo;
        Optional<CategoryEntity> result = cRepository.findByName(this.name);
        if (result.isPresent()) {
            CategoryEntity org = result.get();
            org.setDescription(this.Description);
            cRepository.save(org);
            return ResponseEntity.ok(org);
        } else {
            return ResponseEntity.ok("not found");
        }
    }

    //User Story #37
    public boolean DeleteCategory() {
        CategoryRepository cRepository = CategoryRepositoryInjector.repo;
        Optional<CategoryEntity> result = cRepository.findByName(this.name);
        if (result.isPresent()) {
            cRepository.deleteById(this.name);
            return true;
        } else {
            return false;
        }
    }

    //User Story #38
    public ResponseEntity<?> SearchCategory() {
        CategoryRepository cRepository = CategoryRepositoryInjector.repo;
        Optional<CategoryEntity> result = cRepository.findByName(this.name);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.ok("not found");
        }
    }
}
