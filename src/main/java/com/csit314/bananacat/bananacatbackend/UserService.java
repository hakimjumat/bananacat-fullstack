package com.csit314.bananacat.bananacatbackend;


import org.springframework.stereotype.Service;

import com.csit314.bananacat.bananacatbackend.User.UserProfile;

import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.csit314.bananacat.bananacatbackend.User.Status;



@Service
public class UserService {

    private final UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    public UserService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    } 

    public User login(String email) {
    // return usersRepository.findByEmailAndPassword(email, password);
    Optional<User> userOptional = usersRepository.findByEmail(email);
    if (userOptional.isPresent()) {
        User user = userOptional.get();
        return user;
        } else {
        return null;
        }
    }

    private User loggedInUser; // This will hold the logged-in user
    public User logout() {
        if (loggedInUser != null) {
            loggedInUser.setLoggedIn(false); // This is your logout logic
            usersRepository.save(loggedInUser);
            User temp = loggedInUser; // Store the user object to log out
            loggedInUser = null; // Clear the user object to log out
            return temp;
        }
        return null;
    }

    public User authenticate(String email, String password) {
        Optional<User> userOptional = usersRepository.findByEmail(email);
        
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }
    public boolean create(String email, String password, UserProfile userprofile, String firstname, String lastname, Integer phonenumber, String address) {
        Optional<User> userOptional = usersRepository.findByEmail(email);

        if (userOptional.isPresent()) {
            return  false;
        }

        if (userprofile.equals(UserProfile.HOMEOWNER)) {
            if  (address == null || address.isBlank()) {
                return false;
            }
        }

        else {
            if (address != null && !address.isBlank()) {
                return false;
            }
        }//debate

        if (!(userprofile.equals(UserProfile.HOMEOWNER) && address != null)) {
            return false;
        }

        User newuser = new User();
        newuser.setEmail(email);
        newuser.setPassword(passwordEncoder.encode(password));// database has to store a hashed pass
        newuser.setUserProfile(userprofile);
        newuser.setStatus(Status.ACTIVE);
        newuser.setFirstname(firstname);
        newuser.setLastname(lastname);
        newuser.setPhonenumber(phonenumber);
        newuser.setAddress(address);

        usersRepository.save(newuser);
        
        return true;
    }
}

