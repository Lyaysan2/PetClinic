package ru.itis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dto.request.PetRequest;
import ru.itis.dto.response.AnimalTypeResponse;
import ru.itis.model.AnimalTypeEntity;
import ru.itis.model.PetEntity;
import ru.itis.model.UserEntity;
import ru.itis.repository.AnimalTypeRepository;
import ru.itis.repository.PetRepository;
import ru.itis.service.AnimalTypeService;
import ru.itis.service.PetService;
import ru.itis.service.UserService;
import ru.itis.util.mapper.AnimalTypeMapper;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final UserService userService;

    private final AnimalTypeService animalTypeService;

    private final PetRepository petRepository;

    @Override
    public List<AnimalTypeResponse> getAllAnimalType() {
        return animalTypeService.getAllAnimalType();
    }

    @Override
    public UUID savePet(PetRequest petRequest) {
        PetEntity newPet = PetEntity.builder()
                .user(userService.getById(petRequest.getUserId()))
                .animalType(animalTypeService.getById(petRequest.getAnimalTypeId()))
                .name(petRequest.getName())
                .build();
        return petRepository.save(newPet).getId();
    }
}
