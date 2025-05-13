package in.org.bricks.ai.lms.Bricks.controllers;


import in.org.bricks.ai.lms.Bricks.dtos.SignupRequest;
import in.org.bricks.ai.lms.Bricks.dtos.UserDto;
import in.org.bricks.ai.lms.Bricks.services.auth.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;


    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest){

        UserDto createdUserDto = authService.createUser(signupRequest);

        if(createdUserDto == null){
            return new ResponseEntity<>("Failed to create user!" , HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdUserDto , HttpStatus.CREATED);
    }
}
