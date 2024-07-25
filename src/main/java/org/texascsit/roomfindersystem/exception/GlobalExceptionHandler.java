package org.texascsit.roomfindersystem.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleResourceNotFoundException(ResourceNotFoundException ex) {
        String message = ex.getMessage();
        return message;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public String handleConstraintViolationException(ConstraintViolationException ex) {
        String message = ex.getMessage();
        String regex = "unique_\\w+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(message);
        if (matcher.find()) {
            String result = matcher.group();
            String substring = result.substring("unique_".length());
            String columnsName = substring.replace("_", " ");
            return columnsName + "must be unique";
        }
        return "ERROR";
    }
}