package com.example.mobileappwspractise.exceptions;


import java.io.Serial;

public class UserServiceException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1234599003042847L;

    public UserServiceException(String message) {
        super(message);
    }
}
