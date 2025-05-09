package com.csit314.bananacat.bananacatbackend;

import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name="cleaningservice")
public class CleaningServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//this will allow id to be ignored by requestbody, in short json dont need to send id
    private Long id; //most likely wont be usin this pk at all, only reason im using id as pk is cause composite pk(email and name) is a pain in the ass to set up
    private String email;
    private String serviceName;
    private String tag;

    public Long getId() {
        return id;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean CreateCleaningService(CleaningServiceRepository CSRepository) {
        
        Optional<CleaningServiceEntity> CSoptional = CSRepository.findByEmailandName(this.email, this.serviceName);

        if (CSoptional.isPresent()) {
            return false;
        }
        CSRepository.save(this);
        return true;
    }

    //for viewing all cleaning service
    public ResponseEntity<?> ViewCleaningServiceList(CleaningServiceRepository CSRepository) {
        List<CleaningServiceEntity> CSlist = CSRepository.findByEmail(this.email);
        return (ResponseEntity.ok(CSlist));
    }

    //for viewing specific service
    public ResponseEntity<?> ViewCleaningService(CleaningServiceRepository CSRepository) {
        Optional<CleaningServiceEntity> CSoptional = CSRepository.findByEmailandName(this.email, this.serviceName);

        if (!(CSoptional.isPresent())) {
            return ResponseEntity.ok("not found");
        } else {
            return ResponseEntity.ok(CSoptional.get());
        }
    }

    @Transactional
    public ResponseEntity<?> UpdateCleaningService(CleaningServiceRepository CSRepository) {
        Optional<CleaningServiceEntity> CSoptional = CSRepository.findByEmailandName(this.email, this.serviceName);
        if (CSoptional.isPresent()) {
            CleaningServiceEntity org = CSoptional.get();
            if (serviceName != null) {
                org.setServiceName(this.serviceName);
            }
            if (tag != null) {
                org.setTag(this.tag);
            }
            CSRepository.save(org);
            return ResponseEntity.ok(org);
        } else {
            return ResponseEntity.ok("not found");
        }
    }

    @Transactional
    public boolean DeleteCleaningService(CleaningServiceRepository CSRepository) {
        Optional<CleaningServiceEntity> CSoptional = CSRepository.findByEmailandName(this.email, this.serviceName);
        if (CSoptional.isPresent()) {
            CleaningServiceEntity CS = CSoptional.get();
            CSRepository.deleteById(CS.getId());
            return true;
        } else {
            return false;
        }
    }

    public ResponseEntity<?> SearchCleaningService(CleaningServiceRepository CSRepository) {
        Optional<CleaningServiceEntity> CSoptional = CSRepository.findByEmailandName(this.email, this.serviceName);
        if(CSoptional.isPresent()) {
            return ResponseEntity.ok(CSoptional.get());
        } else {
            return ResponseEntity.ok("not found");
        }
    }
}
