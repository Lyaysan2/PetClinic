package ru.itis.service;

import ru.itis.dto.request.PetRequest;
import ru.itis.dto.response.AnimalTypeResponse;
import ru.itis.dto.response.PetResponse;
import ru.itis.model.PetEntity;
import ru.itis.model.UserEntity;

import java.util.List;
import java.util.UUID;

public interface PetService {

    List<AnimalTypeResponse> getAllAnimalType();

    UUID savePet(PetRequest petRequest);

    List<PetResponse> getAllPetByUser(UserEntity user);
}
