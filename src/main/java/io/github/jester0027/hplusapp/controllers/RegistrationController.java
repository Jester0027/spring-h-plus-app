package io.github.jester0027.hplusapp.controllers;

import io.github.jester0027.hplusapp.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @PostMapping("/register")
    public String register(@ModelAttribute("newuser") User user) {
        return "login";
    }
}
