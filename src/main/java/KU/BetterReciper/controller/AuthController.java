package KU.BetterReciper.controller;

import KU.BetterReciper.dto.SignupDto;
import KU.BetterReciper.service.SignupService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private SignupService signupService;

    @PostMapping("/signup")
    public ResponseEntity signupMember(@Valid @RequestBody SignupDto member) {
        if (!signupService.isUsernameAvailable(member.getUsername())) {
            return new ResponseEntity("Username is not available", HttpStatus.BAD_REQUEST);
        }

        signupService.createMember(member);

        return new ResponseEntity<>("User Registered Successfully", HttpStatus.ACCEPTED);
    }

    @GetMapping("/signup/valid/{username}")
    public ResponseEntity isValidUsername(@PathVariable(value = "username") String username) {
        return new ResponseEntity(signupService.isUsernameAvailable(username), HttpStatus.ACCEPTED);
    }
}
