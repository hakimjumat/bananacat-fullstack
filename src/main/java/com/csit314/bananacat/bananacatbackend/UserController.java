// package com.csit314.bananacat.bananacatbackend;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;



// @Controller
// public class UserController {

//     @Autowired
//     private final UserService userscervice;

//     public UserController (UserService userservice) {
//         this.userscervice = userservice;
//     }

//     @PostMapping("path")//need to change path
//     public User Login(@RequestBody LoginDTO loginDTO) {//depends on what format does frontend send, currently @RequestBody is for if frontend sends JSON 
//         String email = loginDTO.getEmail();
//         String password = loginDTO.getPassword();

//         User authenticated = userscervice.authenticate(email, password);
//         if (authenticated != null) {
//             return authenticated;//return either String message or a token depends on frontend
//         }
        
//         return null;//return either String message or a token depends on frontend
//     }
    
    
// }
