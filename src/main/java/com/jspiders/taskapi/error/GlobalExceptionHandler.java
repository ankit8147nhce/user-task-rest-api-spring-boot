package com.jspiders.taskapi.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> arithmeticExceptionHandler(ArithmeticException ex)
    {
        System.out.println("Handling ArithmeticException");
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                .body("Something went wrong");
    }

    @ExceptionHandler(NullPointerException.class)
public ResponseEntity<String> nullPointerExceptionHandler(NullPointerException ex)
{
    System.out.println("Handling NullPointerException");
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("Something went wrong");
}

    //custom exceptions
    @ExceptionHandler(InvalidNameException.class)
    public ResponseEntity<String> invalidNameExceptionHandler(InvalidNameException ex)
    {
        System.out.println("Handling InvalidNameException");
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

    //custom exceptions
    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<String> invalidEmailExceptionHandler(InvalidEmailException ex)
    {
        System.out.println("Handling InvalidEmailException");
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

    //custom exceptions
    @ExceptionHandler(InvalidMobileException.class)
    public ResponseEntity<String> invalidMobileExceptionHandler(InvalidMobileException ex)
    {
        System.out.println("Handling InvalidMobileException");
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

    //custom exceptions
    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<String> invalidPasswordExceptionHandler(InvalidPasswordException ex)
    {
        System.out.println("Handling InvalidPasswordException");
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

}


