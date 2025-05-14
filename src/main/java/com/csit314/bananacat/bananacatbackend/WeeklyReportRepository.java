package com.csit314.bananacat.bananacatbackend;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WeeklyReportRepository extends JpaRepository<WeeklyReportEntity, Long>{
    Optional<WeeklyReportEntity> findByDate(String date);
}
