package com.jspiders.taskapi.error;


//Note: These classes are not required until we do manual Exception handling.
// that is if we are using Bean Validation, then these classes are not required.
public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException(String message) {
        super(message);
    }
}
