package ru.itis.exception;

import java.util.UUID;

public class FileInfoNotFoundException extends ProjectNotFoundException{
    public FileInfoNotFoundException(UUID id) {
        super(String.format("File info with id %s not found in db", id));
    }
}
