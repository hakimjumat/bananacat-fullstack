package com.csit314.bananacat.bananacatbackend;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "monthlyreport")
public class MonthlyReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private Integer duration;
    private String date; //format (YYYY-MM), i didnt use localdate cause i want to store in db in YYYY-MM format

    //User Story #41
    public ResponseEntity<?> GenerateMonthlyReport() {
        MonthlyReportRepository mrRepository = MonthlyReportRepositoryInjector.repo;
        Optional<MonthlyReportEntity> result = mrRepository.findByDate(this.date);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.ok("not found");
        }
    }
}
