package ru.itis.exception;

public class TimeSlotNotFoundException extends ProjectNotFoundException{

    public TimeSlotNotFoundException() {
        super("Time slot not found");
    }
}
