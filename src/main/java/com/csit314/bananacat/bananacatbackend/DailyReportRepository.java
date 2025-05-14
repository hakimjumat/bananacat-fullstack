package com.csit314.bananacat.bananacatbackend;

import java.time.LocalDate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyReportRepository extends JpaRepository<DailyReportEntity, Long>{
    Optional<DailyReportEntity> findByDate(LocalDate date);
}
