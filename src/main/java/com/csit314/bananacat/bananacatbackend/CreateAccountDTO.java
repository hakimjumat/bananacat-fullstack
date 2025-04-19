package com.csit314.bananacat.bananacatbackend;

import com.csit314.bananacat.bananacatbackend.User.UserProfile;

public class CreateAccountDTO {
    private String email;
    private String password;
    private UserProfile userprofile;
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
    public UserProfile getUserprofile() {
        return userprofile;
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

    
}
