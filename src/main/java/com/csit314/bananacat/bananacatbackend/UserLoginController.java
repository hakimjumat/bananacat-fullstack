package com.csit314.bananacat.bananacatbackend;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
// import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;



@RestController

public class UserLoginController {

    @Autowired
    private final UserService userService;
    
    public UserLoginController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/api/auth/login")//need to change path
    public ResponseEntity<?> Login(@RequestBody LoginDTO loginDTO) {//depends on what format does frontend send, currently @RequestBody is for if frontend sends JSON 
        String email = loginDTO.getEmail();
        String password = loginDTO.getPassword();

        User authenticated = userService.authenticate(email, password);
        if (authenticated != null) {
            return ResponseEntity.ok(authenticated);//return either String message or a token depends on frontend
        }
        
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");//return either String message or a token depends on frontend
    }

}

// @RestController
// @RequestMapping("/api/auth")
// public class UserLoginController {

//     private final UserService userService;

//     public UserLoginController(UserService userService) {
//         this.userService = userService;
//     }

//     @PostMapping("/login")
//     public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
//         String email = body.get("email");
//         String password = body.get("password");

//         User user = userService.authenticate(email, password);
//         if (user != null) {
//             return ResponseEntity.ok(user);
//         } else {
//             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//         }
//     }
// }
