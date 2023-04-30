package ru.itis.exception;

public class ServiceNotFoundException extends ProjectNotFoundException{

    public ServiceNotFoundException() {
        super("Service not found");
    }
}
