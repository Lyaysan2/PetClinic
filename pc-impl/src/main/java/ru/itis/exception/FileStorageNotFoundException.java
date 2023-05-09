package ru.itis.exception;

public class FileStorageNotFoundException extends ProjectNotFoundException{
    public FileStorageNotFoundException(String id) {
        super(String.format("File with id %s not found in storage", id));
    }
}
