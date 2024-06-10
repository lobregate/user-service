package com.fiapst1.user_service.exceptions;

public class BadPasswordException extends RuntimeException {
    public BadPasswordException(String message){
        super(message);
    }
}
