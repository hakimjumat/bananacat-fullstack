package com.csit314.bananacat.bananacatbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CleaningServiceRepositoryInjector {
    public static CleaningServiceRepository repo;

    @Autowired
    public CleaningServiceRepositoryInjector(CleaningServiceRepository injectrepo) {
        CleaningServiceRepositoryInjector.repo = injectrepo;
    }
}
