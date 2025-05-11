package com.csit314.bananacat.bananacatbackend;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "weeklyreport")
public class WeeklyReportEntity {
    @Id
    private Long Id;
    private String name;
    private Integer duration;
    private String date;//havent decide on the format maaybe try (YYYY-MM-DD to YYYY-MM-DD) ? can discuss on tuesday

    public ResponseEntity<?> GenerateWeeklyReport() {
        WeeklyReportRepository wrRepository = WeeklyReportRepositoryInjector.repo;
        Optional<WeeklyReportEntity> result = wrRepository.findByDate(this.date);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.ok("not found");
        }
    }
}
