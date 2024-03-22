package com.example.springmodelmapper.exception;

public class UserNotFoundException extends RuntimeException{

    private final static String MESSAGE="User Not Found";

    public UserNotFoundException(){
        super(MESSAGE);
    }

}
