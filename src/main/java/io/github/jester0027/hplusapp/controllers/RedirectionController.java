package io.github.jester0027.hplusapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectionController {
    @GetMapping("linkedInRedirect")
    public String redirectToLinkedIn() {
        return "redirect:https://www.linkedin.com";
    }
}
