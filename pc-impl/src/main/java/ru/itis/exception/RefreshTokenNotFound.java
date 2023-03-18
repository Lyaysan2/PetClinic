package ru.itis.exception;

public class RefreshTokenNotFound extends ProjectNotFoundException{
    public RefreshTokenNotFound() {
        super("refresh token not found");
    }
}
