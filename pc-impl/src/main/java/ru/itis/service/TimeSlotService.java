package ru.itis.service;

import ru.itis.model.TimeSlotEntity;

import java.util.UUID;

public interface TimeSlotService {

    TimeSlotEntity getById(UUID id);

    UUID save(TimeSlotEntity timeSlotEntity);
}
