package com.csit314.bananacat.bananacatbackend;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//category is actually the tag variable in cleaning service entity
@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

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

    public ResponseEntity<?> ViewCategoryList() {
        CategoryRepository cRepository = CategoryRepositoryInjector.repo;
        return ResponseEntity.ok(cRepository.findAll());
    }

    //User Story #36
    public ResponseEntity<?> UpdateCategory() {
        CategoryRepository cRepository = CategoryRepositoryInjector.repo;
        Optional<CategoryEntity> result = cRepository.findByName(this.name);
        if (result.isPresent()) {
            CategoryEntity org = result.get();
            org.setDescription(this.description);
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
            cRepository.deleteById(result.get().getId());
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

    //for cleaner creating cleaning service, this method will run on webpage load, to retrieve all the category from db
    public ResponseEntity<?> CategoryDropDownList() {
        CategoryRepository cRepository = CategoryRepositoryInjector.repo;
        return ResponseEntity.ok(cRepository.findAll());
    }
}
