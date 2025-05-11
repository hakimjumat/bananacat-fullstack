package com.csit314.bananacat.bananacatbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryRepositoryInjector {
    public static CategoryRepository repo;

    @Autowired
    public CategoryRepositoryInjector(CategoryRepository injectrepo) {
        CategoryRepositoryInjector.repo = injectrepo;
    }
}
