package com.csit314.bananacat.bananacatbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HistoryRepositoryInjector {
    public static HistoryRepository repo;

    @Autowired
    public HistoryRepositoryInjector(HistoryRepository injectrepo) {
        HistoryRepositoryInjector.repo = injectrepo;
    }
}
