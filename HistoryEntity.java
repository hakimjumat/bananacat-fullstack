package com.csit314.bananacat.bananacatbackend;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.*;

@Entity
@Table(name = "history")
public class HistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String CLemail;
    private String HOemail;
    private LocalDate date;
    private String serviceName; //match with cleaning service service name

    //User Story #92, #23
    public ResponseEntity<?> ViewHistoryList() {
        HistoryRepository Hrepository = HistoryRepositoryInjector.repo;
        List<HistoryEntity> result = Hrepository.findByCLemail(this.CLemail);
        return ResponseEntity.ok(result);
    }

    //User Story not yet created
    public ResponseEntity<?> ViewHistoryIndividual() {
        HistoryRepository Hrepository = HistoryRepositoryInjector.repo;
        Optional<HistoryEntity> result = Hrepository.findById(this.id);
        return ResponseEntity.ok(result.get());
    }
}
