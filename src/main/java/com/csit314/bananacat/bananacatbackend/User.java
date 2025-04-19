package com.csit314.bananacat.bananacatbackend;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
@Table(name="useraccount")
public class User {

    @Id
    private String email;
    private String password;
    
    public enum UserProfile {
        ADMIN,
        CLEANER,
        HOMEOWNER,
        MANAGER;
    }

    @Enumerated(EnumType.STRING)
    private UserProfile userprofile;

    public enum Status {
        ACTIVE,
        SUSPENDED;
    }

    @Enumerated(EnumType.STRING)
    private Status status;
    
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Integer getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(Integer phonenumber) {
        this.phonenumber = phonenumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    private String firstname;
    private String lastname;
    private Integer phonenumber;
    private String address;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public UserProfile getUserProfile() {
        return userprofile;
    }
    public void setUserProfile(UserProfile userprofile) {
        this.userprofile = userprofile;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    private boolean loggedIn;

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((userprofile == null) ? 0 : userprofile.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
        result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
        result = prime * result + ((phonenumber == null) ? 0 : phonenumber.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (userprofile == null) {
            if (other.userprofile != null)
                return false;
        } else if (!userprofile.equals(other.userprofile))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        if (firstname == null) {
            if (other.firstname != null)
                return false;
        } else if (!firstname.equals(other.firstname))
            return false;
        if (lastname == null) {
            if (other.lastname != null)
                return false;
        } else if (!lastname.equals(other.lastname))
            return false;
        if (phonenumber == null) {
            if (other.phonenumber != null)
                return false;
        } else if (!phonenumber.equals(other.phonenumber))
            return false;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "User [email=" + email + ", UserProfile=" + userprofile + ", Status=" + status + ", firstname="
                + firstname + ", lastname=" + lastname + ", phonenumber=" + phonenumber + ", address=" + address + "]";
    }
}
