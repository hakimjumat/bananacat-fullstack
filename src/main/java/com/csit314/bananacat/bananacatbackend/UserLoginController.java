package com.csit314.bananacat.bananacatbackend;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
// import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;



@RestController
@RequestMapping("/api/auth")
public class UserLoginController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        User user = userService.login(loginDTO.getEmail());

        if (user != null) {
            user.setLoggedIn(true);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
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
