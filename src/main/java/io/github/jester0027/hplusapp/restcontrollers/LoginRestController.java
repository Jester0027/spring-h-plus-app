package io.github.jester0027.hplusapp.restcontrollers;

import io.github.jester0027.hplusapp.beans.Login;
import io.github.jester0027.hplusapp.beans.User;
import io.github.jester0027.hplusapp.exceptions.LoginFailureException;
import io.github.jester0027.hplusapp.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginRestController {

    private final UserRepository userRepository;

    public LoginRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping()
    public ResponseEntity login(@RequestBody Login login) {
        User user = userRepository.searchByName(login.getUsername());
        if (user == null) {
            return ResponseEntity.status(404).build();
        }
        if (user.getUsername().equals(login.getUsername()) && user.getPassword().equals(login.getPassword())) {
            return  ResponseEntity.status(200).build();
        }
        throw new LoginFailureException("Invalid username or password");
    }
}
