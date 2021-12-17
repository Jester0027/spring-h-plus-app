package io.github.jester0027.hplusapp.controllers;

import io.github.jester0027.hplusapp.beans.Login;
import io.github.jester0027.hplusapp.beans.User;
import io.github.jester0027.hplusapp.exceptions.ApplicationException;
import io.github.jester0027.hplusapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@ModelAttribute("login") Login login) {
        User user = userRepository.searchByName(login.getUsername());
        if (user == null) {
            throw new ApplicationException("User not found");
        }
        return "redirect:/goToSearch";
    }

//    @ExceptionHandler(ApplicationException.class)
//    public String handleException() {
//        System.out.println("In exception handler of Login controller");
//        return "error";
//    }
}
