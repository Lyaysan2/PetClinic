package ru.itis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.exception.TimeSlotNotFoundException;
import ru.itis.model.TimeSlotEntity;
import ru.itis.repository.TimeSlotRepository;
import ru.itis.service.TimeSlotService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TimeSlotServiceImpl implements TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;

    @Override
    public TimeSlotEntity getById(UUID id) {
        return timeSlotRepository.findById(id).orElseThrow(TimeSlotNotFoundException::new);
    }

    @Override
    public UUID save(TimeSlotEntity timeSlotEntity) {
        return timeSlotRepository.save(timeSlotEntity).getId();
    }
}
