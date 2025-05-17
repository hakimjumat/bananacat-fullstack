package com.csit314.bananacat.bananacatbackend;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.*;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Table;
@Entity
@Table (name = "shortlist")
public class shortlistEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JsonProperty("hoEmail")
    private String HOemail;

    @JsonProperty("clEmail")
    private String CLemail;
    
    private String name;//name of cleaning service

    public Long getId() {
        return id;
    }

    public String getHOemail() {
        return HOemail;
    }

    public String getCLemail() {
        return CLemail;
    }

    public String getName() {
        return name;
    }

    public void setHOemail(String HOemail) {
        this.HOemail = HOemail;
    }

    public void setCLemail(String CLemail) {
        this.CLemail = CLemail;
    }

    public void setName(String name) {
        this.name = name;
    }

    //User story #24
    public boolean SaveShortlist() {
        shortlistRepository slRepository = shortlistRepositoryInjector.repo;
        Optional<shortlistEntity> slOptional = slRepository.findByHOemailAndCLemailAndName(this.HOemail, this.CLemail, this.name);
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
        Optional<shortlistEntity> slOptional = slRepository.findByHOemailAndCLemailAndName(this.HOemail, this.CLemail, this.name);
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
        List<shortlistEntity> slOptional = slRepository.findByHOemailAndName(this.HOemail, this.name);
        return ResponseEntity.ok(slOptional);
    }

    //User story #16
    public ResponseEntity<?> NumberofShortlist() {
        shortlistRepository slRepository = shortlistRepositoryInjector.repo;
        int result = slRepository.CountByEmailAndName(this.CLemail, this.name);
        return ResponseEntity.ok(result);
    }

    
}
