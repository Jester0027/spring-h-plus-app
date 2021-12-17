package io.github.jester0027.hplusapp.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler(ApplicationException.class)
    public String handleException(ApplicationException exception, Model model) {
        System.out.println(exception.getMessage());
        model.addAttribute("errorMessage", exception.getMessage());
        return "error";
    }
}
