package io.github.jester0027.hplusapp.controllers;

import io.github.jester0027.hplusapp.beans.Login;
import io.github.jester0027.hplusapp.beans.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class DefaultModelAttributeController {
    @ModelAttribute("newuser")
    public User getDefaultUser() {
        return new User();
    }

    @ModelAttribute("genderItems")
    public List<String> getGenderItems() {
        return Arrays.asList("Male", "Female", "Other");
    }

    @ModelAttribute("login")
    public Login getLogin() {
        return new Login();
    }
}
