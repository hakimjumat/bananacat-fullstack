package com.csit314.bananacat.bananacatbackend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.*;
import org.springframework.http.ResponseEntity;
import jakarta.persistence.Table;

@Entity
@Table (name = "shortlist")
public class shortlistEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String HOemail;
    private String CLemail;

    //User story #24
    public boolean SaveShortlist() {
        shortlistRepository slRepository = shortlistRepositoryInjector.repo;
        Optional<shortlistEntity> slOptional = slRepository.findBybothEmail(this.HOemail, this.CLemail);
        if (slOptional.isPresent()) {
            return false;
        } else {
            slRepository.save(this);
            return true;
        }
    }

    //User story #25
    public ResponseEntity<?> ViewShortlistIndividual() {
        shortlistRepository slRepository = shortlistRepositoryInjector.repo;
        Optional<shortlistEntity> slOptional = slRepository.findBybothEmail(this.HOemail, this.CLemail);
        if (slOptional.isPresent()) {
            return ResponseEntity.ok(slOptional.get());
        } else {
            return ResponseEntity.ok("not found");
        }
    }

    public ResponseEntity<?> ViewShortlist() {
        shortlistRepository slRepository = shortlistRepositoryInjector.repo;
        List<shortlistEntity> slList = slRepository.findByHOemail(this.HOemail);
        return ResponseEntity.ok(slList);
    }

    //User story #29
    public ResponseEntity<?> SearchShortlist() {
        shortlistRepository slRepository = shortlistRepositoryInjector.repo;
        Optional<shortlistEntity> slOptional = slRepository.findBybothEmail(this.HOemail, this.CLemail);
        if (slOptional.isPresent()) {
            return ResponseEntity.ok(slOptional.get());
        } else {
            return ResponseEntity.ok("not found");
        }
    }
}
