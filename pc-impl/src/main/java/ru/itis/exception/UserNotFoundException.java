package ru.itis.exception;

public class UserNotFoundException extends ProjectNotFoundException{

    public UserNotFoundException() {
        super("User not found");
    }
}