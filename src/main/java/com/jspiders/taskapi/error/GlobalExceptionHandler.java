package com.jspiders.taskapi.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> arithmeticExceptionHandler(ArithmeticException ex)
    {
        log.error("Handling ArithmeticException ",ex);
        //System.out.println("Handling ArithmeticException");
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                .body("Something went wrong");
    }

    @ExceptionHandler(NullPointerException.class)
public ResponseEntity<String> nullPointerExceptionHandler(NullPointerException ex)
{
    log.error("Handling NullPointerException ",ex);
    //System.out.println("Handling NullPointerException");
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("Something went wrong");
}
//*****************************************************
    // IllegalArgumentException : Manual Java validation
// *****************************************************


//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<String> illegalArgumentExceptionHandler(IllegalArgumentException ex)
//    {
//        System.out.println("Handling illegalArgumentException");
//        ex.printStackTrace();
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Name cannot be blank/empty");
//    }

    //*********************************************************
    //Custom exception starts : InvalidNameException , InvalidEmailException , InvalidMobileException , InvalidPasswordException
    //*********************************************************

    //custom exceptions
//    @ExceptionHandler(InvalidNameException.class)
//    public ResponseEntity<String> invalidNameExceptionHandler(InvalidNameException ex)
//    {
//        System.out.println("Handling InvalidNameException");
//        ex.printStackTrace();
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body(ex.getMessage());
//    }

    //custom exceptions
//    @ExceptionHandler(InvalidEmailException.class)
//    public ResponseEntity<String> invalidEmailExceptionHandler(InvalidEmailException ex)
//    {
//        System.out.println("Handling InvalidEmailException");
//        ex.printStackTrace();
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body(ex.getMessage());
//    }

    //custom exceptions
//    @ExceptionHandler(InvalidMobileException.class)
//    public ResponseEntity<String> invalidMobileExceptionHandler(InvalidMobileException ex)
//    {
//        System.out.println("Handling InvalidMobileException");
//        ex.printStackTrace();
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body(ex.getMessage());
//    }

    //custom exceptions
//    @ExceptionHandler(InvalidPasswordException.class)
//    public ResponseEntity<String> invalidPasswordExceptionHandler(InvalidPasswordException ex)
//    {
//        System.out.println("Handling InvalidPasswordException");
//        ex.printStackTrace();
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body(ex.getMessage());
//    }


    //*********************************************************
    //Custom exception ends
    //*********************************************************


    //*************************************************************
    // Framework validation : Bean Validation : MethodArgumentNotValidException
    //***************************************************
    //MethodArgumentNotValidExceptionHandler
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex){

//         By doing this we can get only one error at a time.....
//        FieldError fieldError =ex.getFieldError();
//        String field = fieldError.getField();
//        String errorMessage = fieldError.getDefaultMessage();
//        Map<String,String> errorMap = new HashMap<>();
//        errorMap.put(field,errorMessage);


//      By doing this we can handle multiple errors at once
        Map<String,String> errorMap = new HashMap<>();
        List<FieldError> fieldErrors = ex.getFieldErrors();

        for(FieldError fieldError : fieldErrors){
            String field = fieldError.getField();
             String errorMessage = fieldError.getDefaultMessage();
             errorMap.put(field,errorMessage);
        }
        log.error("Validation Error : {}",errorMap);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
    }

}


