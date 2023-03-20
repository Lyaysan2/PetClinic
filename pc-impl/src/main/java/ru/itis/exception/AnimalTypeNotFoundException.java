package ru.itis.exception;

public class AnimalTypeNotFoundException extends ProjectNotFoundException{
    public AnimalTypeNotFoundException() {
        super("Animal type not found");
    }
}
