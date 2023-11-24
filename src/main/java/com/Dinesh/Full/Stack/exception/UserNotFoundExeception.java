package com.Dinesh.Full.Stack.exception;

public class UserNotFoundExeception extends RuntimeException{
    public UserNotFoundExeception(Long id){
        super("Could not get the user with the id"+id);
    }
}
