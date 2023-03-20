package ru.itis.service;

import ru.itis.dto.response.AnimalTypeResponse;
import ru.itis.model.AnimalTypeEntity;

import java.util.List;
import java.util.UUID;

public interface AnimalTypeService {

    AnimalTypeEntity getById(UUID id);

    List<AnimalTypeResponse> getAllAnimalType();
}
