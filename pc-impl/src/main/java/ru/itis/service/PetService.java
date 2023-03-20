package ru.itis.service;

import ru.itis.dto.request.PetRequest;
import ru.itis.dto.response.AnimalTypeResponse;

import java.util.List;
import java.util.UUID;

public interface PetService {

    List<AnimalTypeResponse> getAllAnimalType();

    UUID savePet(PetRequest petRequest);
}
