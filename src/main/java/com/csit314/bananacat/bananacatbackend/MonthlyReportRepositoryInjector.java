package com.csit314.bananacat.bananacatbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MonthlyReportRepositoryInjector {
    public static MonthlyReportRepository repo;

    @Autowired
    public MonthlyReportRepositoryInjector(MonthlyReportRepository injectrepo) {
        MonthlyReportRepositoryInjector.repo = injectrepo;
    }
}
