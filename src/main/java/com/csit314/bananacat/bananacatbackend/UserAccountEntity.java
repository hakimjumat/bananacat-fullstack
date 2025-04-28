package com.csit314.bananacat.bananacatbackend;

import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Table(name="useraccount")
public class UserAccountEntity {

    @Id
    private String email;
    @JsonIgnore
    private String password;
    private String userprofile;
    private String status;
    private String firstname;
    private String lastname;
    private Integer phonenumber;
    private String address;
    
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getUserprofile() {
        return userprofile;
    }
    public String getStatus() {
        return status;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public Integer getPhonenumber() {
        return phonenumber;
    }
    public String getAddress() {
        return address;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUserprofile(String userprofile) {
        this.userprofile = userprofile;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setPhonenumber(Integer phonenumber) {
        this.phonenumber = phonenumber;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
    public static ResponseEntity<?> login(UserAccountRepository usersrepository, HttpSession session, PasswordEncoder passwordEncoder, String email, String password) {
        if (email == null || password == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Email or password cannot be empty");
        }
    
        Optional<UserAccountEntity> useroptional = usersrepository.findByEmail(email);
    
        if (useroptional.isPresent()) {
            UserAccountEntity auth = useroptional.get();
            if (passwordEncoder.matches(password, auth.getPassword())) {
                session.setAttribute("useremail", email);
                return ResponseEntity.ok(auth); //  Return the full user object
            } else {
                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body("Wrong password");
            }
        } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("User not found");
        }
    }
    
    public ResponseEntity<?> logout(HttpSession session) {
        if (session.getAttribute("useremail") != null) {
            session.invalidate();
            return ResponseEntity.ok("Logout successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in");
        }
    }

    public boolean CreateUserAccount(UserAccountRepository usersrepository, PasswordEncoder passwordEncoder) {

        if (this.email == null || this.password == null || this.userprofile == null || this.firstname == null || this.lastname == null || this.phonenumber == null) {
            return false;
        }

        Optional<UserAccountEntity> userOptional = usersrepository.findByEmail(this.email);

        if (userOptional.isPresent()) {
            return false;
        }

        if (this.userprofile.equals("Home Owner")) {
            if  (this.address == null || this.address.isBlank()) {
                return false;
            }
        }

        setPassword(passwordEncoder.encode(password));
        usersrepository.save(this);
        return true;
    }

    @Transactional
    public boolean SuspendUserAccount(UserAccountRepository usersrepository) {

        if (this.email == null) {
            return false;
        }

        Optional<UserAccountEntity> userOptional = usersrepository.findByEmail(this.email);

        if (!(userOptional.isPresent())) {
            return false;
        } else {
            String s = usersrepository.findStatusByEmail(this.email);
            if ("ACTIVE".equals(s)) {
                usersrepository.updateStatusByEmail("SUSPENDED", this.email);
                return true;
            }
        }
        return false;
    }
    
    @Transactional
    public ResponseEntity<?> UpdateUserAccount(UserAccountRepository userrepository) {

        if (this.email == null || this.email.isBlank()) {
            return ResponseEntity.ok("Email not provided");
        }

        if ((this.userprofile != null && this.userprofile.isBlank()) || 
            (this.firstname != null && this.firstname.isBlank()) || 
            (this.lastname != null && this.lastname.isBlank())) {
            return ResponseEntity.ok("Some fields are blank");
        }

        if (this.userprofile.equals("Home Owner")) {
            if  (this.address.isBlank()) {
                return ResponseEntity.ok("Home owner cannot have empty address");
            }
        }

        Optional<UserAccountEntity> userOptional = userrepository.findByEmail(this.email);

        if (userOptional.isPresent()) {
            UserAccountEntity org = userOptional.get();
            if (this.userprofile != null) {
                org.setUserprofile(this.userprofile);
            }
            if (this.firstname != null) {
                org.setFirstname(this.firstname);
            }
            if (this.lastname != null) {
                org.setLastname(this.lastname);
            }
            if (this.phonenumber != null) {
                org.setPhonenumber(this.phonenumber);
            }
            if (this.address != null) {
                org.setAddress(this.address);
            }
            
            userrepository.save(org);
            return ResponseEntity.ok(org);
        } else {
            return ResponseEntity.ok("User not found");
        }
    }

    public ResponseEntity<?> SearchUserAccount(UserAccountRepository usersrepository) {
        Optional<UserAccountEntity> userOptional = usersrepository.findByEmail(this.email);

        if (userOptional.isPresent()) {
            return ResponseEntity.ok(this.email);
        } else {
            return ResponseEntity.ok("User not found");
        }
    }

    public ResponseEntity<?> ViewUserAccount(UserAccountRepository usersrepository) {

        Optional<UserAccountEntity> userOptional = usersrepository.findByEmail(this.email);

        if (userOptional.isPresent()) {
            UserAccountEntity result = userOptional.get();
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.ok("User not found");
        }
    }

    public ResponseEntity<?> ViewUserAccountList(UserAccountRepository usersrepository) {
        return ResponseEntity.ok(usersrepository.findAll());
    }
}
