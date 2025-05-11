package com.csit314.bananacat.bananacatbackend;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.*;

@Entity
@Table(name = "dailyreport")
public class DailyReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private Integer duration;
    private LocalDate date;

    //User story #39
    public ResponseEntity<?> GenerateDailyReport() {
        DailyReportRepository drRepository = DailyReportRepositoryInjector.repo;
        Optional<DailyReportEntity> result = drRepository.findByDate(this.date);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.ok("not found");
        }
    }
}
