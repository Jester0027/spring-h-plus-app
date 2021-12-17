package io.github.jester0027.hplusapp.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;

@ControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler({ApplicationException.class, AsyncRequestTimeoutException.class})
    public String handleException() {
        return "error";
    }
}
