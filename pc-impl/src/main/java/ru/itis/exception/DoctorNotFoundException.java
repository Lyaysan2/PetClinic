package ru.itis.exception;

public class DoctorNotFoundException extends ProjectNotFoundException{

    public DoctorNotFoundException() {
        super("Doctor not found");
    }
}
