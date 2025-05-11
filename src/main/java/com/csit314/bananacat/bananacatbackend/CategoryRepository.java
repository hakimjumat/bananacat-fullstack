package com.csit314.bananacat.bananacatbackend;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, String>{
    Optional<CategoryEntity> findByName(String name);
}
