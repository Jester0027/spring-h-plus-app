package io.github.jester0027.hplusapp.controllers;

import io.github.jester0027.hplusapp.beans.Login;
import io.github.jester0027.hplusapp.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class UserProfileController {
    @PostMapping("/userprofile")
    public String getUserProfile(@SessionAttribute("login") Login login, Model model, @RequestAttribute("profile") User profile) {
        System.out.println("In user profile controller");
        System.out.println("username from session: " + login.getUsername());
        model.addAttribute("username", login.getUsername());
        model.addAttribute("profile", profile);
        return "profile";
    }
}
