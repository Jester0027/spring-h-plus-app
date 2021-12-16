package io.github.jester0027.hplusapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String goHome() {
        System.out.println("in home controller");
        return "index";
    }

    @GetMapping("/goToSearch")
    public String goToSearch() {
        return "search";
    }

    @GetMapping("/goToLogin")
    public String goToLogin() {
        return "login";
    }

    @GetMapping("/goToRegister")
    public String goToRegister() {
        return "register";
    }
}
