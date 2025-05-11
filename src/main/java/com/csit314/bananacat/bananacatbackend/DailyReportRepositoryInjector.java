package com.csit314.bananacat.bananacatbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DailyReportRepositoryInjector {
    public static DailyReportRepository repo;

    @Autowired
    public DailyReportRepositoryInjector(DailyReportRepository injectrepo) {
        DailyReportRepositoryInjector.repo = injectrepo;
    }
}
