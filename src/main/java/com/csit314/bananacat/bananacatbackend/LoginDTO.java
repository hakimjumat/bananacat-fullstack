package com.csit314.bananacat.bananacatbackend;

//DTO is auto created when frontend sends info
public class LoginDTO {
    private String email;
    private String password;
    private boolean loggedIn = false; // Default value is false
    
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

    public boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
