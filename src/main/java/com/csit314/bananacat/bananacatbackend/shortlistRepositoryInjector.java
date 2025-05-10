package com.csit314.bananacat.bananacatbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class shortlistRepositoryInjector {

    public static shortlistRepository repo;

    @Autowired
    public shortlistRepositoryInjector(shortlistRepository injectrepo) {
        shortlistRepositoryInjector.repo = injectrepo;
    }
}
