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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean privilegeToCreateAccount;
    public Boolean privilegeToViewAccountList;
    public Boolean privilegeToViewAccount;
    public Boolean privilegeToUpdateAccount;
    public Boolean privilegeToSuspendAccount;
    public Boolean privilegeToSearchAccount;
    public Boolean privilegeToCreateProfile;
    public Boolean privilegeToUpdateProfile;
    public Boolean privilegeToViewProfileList;
    public Boolean privilegeToViewProfile;
    public Boolean privilegeToDeleteProfile;
    public Boolean privilegeToSearchProfile;

    public boolean CreateUserProfile(UserProfileRepository profilerepository) {
        if (this.name == null) {
            return false;
        }

        Optional<UserProfileEntity> userOptional = profilerepository.findByName(this.name);
        if (userOptional.isPresent()) {
            return false;
        }

        profilerepository.save(this);
        return true;
    }

    public ResponseEntity<?> ViewUserProfile(UserProfileRepository profileRepository) {

        Optional<UserProfileEntity> userOptional = profileRepository.findByName(this.name);
        if (userOptional.isPresent()) {
            UserProfileEntity result = userOptional.get();
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.ok("Profile not found");
        }
    }

    @Transactional
    public ResponseEntity<?> UpdateUserProfile(UserProfileRepository profilerepository) throws IllegalAccessException{

        Optional<UserProfileEntity> userOptional = profilerepository.findByName(this.name);

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

        Optional<UserProfileEntity> userOptional = profilerepository.findByName(this.name);

        if (!(userOptional.isPresent())) {
            return false;
        }
        usersrepository.UpdateUserProfile(null, this.name);
        profilerepository.deleteById(this.name);
        return true;
    }

    public ResponseEntity<?> SearchUserProfile(UserProfileRepository profilerepository) {
        Optional<UserProfileEntity> userOptional = profilerepository.findByName(this.name);

        if (userOptional.isPresent()) {
            return ResponseEntity.ok(this.name);
        } else {
            return ResponseEntity.ok("Profile not found");
        }
    }
}
