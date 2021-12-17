package io.github.jester0027.hplusapp.controllers;

import io.github.jester0027.hplusapp.beans.User;
import io.github.jester0027.hplusapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String register(@ModelAttribute("newuser") User user, Model model) {
        userRepository.save(user);
        model.addAttribute("dataSaved", "User registered successfully");
        return "login";
    }
}
