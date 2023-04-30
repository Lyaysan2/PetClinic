package ru.itis.exception;

public class PetNotFoundException extends ProjectNotFoundException{
    public PetNotFoundException() {
        super("Pet not found");
    }
}
