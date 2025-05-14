package com.csit314.bananacat.bananacatbackend;

import java.util.Optional;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import java.lang.reflect.Field;

@Entity
@Table(name="userprofile")
public class UserProfileEntity {
    @Id
    private String name;
    public Boolean privilege_to_read_write_account;
    public Boolean privilege_to_read_write_profile;
    public Boolean privilege_to_read_write_cleaning_service;
    public Boolean privilege_to_read_history;
    public Boolean privilege_to_read_cleaners;
    public Boolean privilege_to_read_write_shortlist;
    public Boolean privilege_to_write_homeaccount;
    public Boolean privilege_to_read_write_category;
    public Boolean privilege_to_generate_report;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public boolean CreateUserProfile(UserProfileRepository profilerepository) {
        if (this.name == null) {
            return false;
        }

        Optional<UserProfileEntity> userOptional = profilerepository.findByNameIgnoreCase(this.name);
        if (userOptional.isPresent()) {
            return false;
        }

        profilerepository.save(this);
        return true;
    }

    public ResponseEntity<?> ViewUserProfile(UserProfileRepository profileRepository) {
        return ResponseEntity.ok(profileRepository.findAll());
        // Optional<UserProfileEntity> userOptional = profileRepository.findByNameIgnoreCase(this.name);
        // if (userOptional.isPresent()) {
        //     UserProfileEntity result = userOptional.get();
        //     return ResponseEntity.ok(result);
        // } else {
        //     return ResponseEntity.ok("Profile not found");
        // }
    }

    @Transactional
    public ResponseEntity<?> UpdateUserProfile(UserProfileRepository profilerepository) throws IllegalAccessException{

        Optional<UserProfileEntity> userOptional = profilerepository.findByNameIgnoreCase(this.name);

        if (!(userOptional.isPresent())) {
            return ResponseEntity.ok("Profile not found");
        }
        UserProfileEntity org = userOptional.get();
        for (Field f : this.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            Object value = f.get(this);

            if (value != null) {
                f.set(org, value);
            }
        }
        profilerepository.save(org);
        return ResponseEntity.ok(org);
    }

    @Transactional
    public boolean DeleteUserProfile(UserProfileRepository profilerepository, UserAccountRepository usersrepository) {

        Optional<UserProfileEntity> userOptional = profilerepository.findByNameIgnoreCase(this.name);

        if (!(userOptional.isPresent())) {
            return false;
        }
        usersrepository.UpdateUserProfile(null, this.name);
        profilerepository.deleteById(this.name);
        return true;
    }

    public ResponseEntity<?> SearchUserProfile(UserProfileRepository profilerepository) {
        Optional<UserProfileEntity> userOptional = profilerepository.findByNameIgnoreCase(this.name);

        if (userOptional.isPresent()) {
            return ResponseEntity.ok(this.name);
        } else {
            return ResponseEntity.ok("Profile not found");
        }
    }
}
