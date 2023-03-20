package ru.itis.exception;

public class DepartmentNotFoundException extends ProjectNotFoundException{
    public DepartmentNotFoundException() {
        super("Department not found");
    }
}
