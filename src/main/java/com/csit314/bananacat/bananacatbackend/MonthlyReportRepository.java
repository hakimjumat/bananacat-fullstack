package com.csit314.bananacat.bananacatbackend;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface MonthlyReportRepository extends JpaRepository<MonthlyReportEntity, Long>{
    Optional<MonthlyReportEntity> findByDate (String date);
}
