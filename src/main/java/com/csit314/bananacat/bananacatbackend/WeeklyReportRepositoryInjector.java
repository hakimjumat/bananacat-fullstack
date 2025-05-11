package com.csit314.bananacat.bananacatbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeeklyReportRepositoryInjector {
    public static WeeklyReportRepository repo;

    @Autowired
    public WeeklyReportRepositoryInjector(WeeklyReportRepository injectrepo) {
        WeeklyReportRepositoryInjector.repo = injectrepo;
    }
}
