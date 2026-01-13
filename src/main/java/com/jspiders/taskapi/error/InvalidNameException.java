package com.jspiders.taskapi.error;

//Note: These classes are not required until we do manual Exception handling.
// that is if we are using Bean Validation, then these classes are not required.
public class InvalidNameException extends RuntimeException {
    public InvalidNameException(String message) {
        super(message);
    }
}
