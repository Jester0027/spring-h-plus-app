package io.github.jester0027.hplusapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @PostMapping("/register")
    public String register() {
        return "login";
    }
}
