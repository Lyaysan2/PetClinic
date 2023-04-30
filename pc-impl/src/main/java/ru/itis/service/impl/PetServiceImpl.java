package ru.itis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dto.request.PetRequest;
import ru.itis.dto.response.AnimalTypeResponse;
import ru.itis.dto.response.PetResponse;
import ru.itis.exception.PetNotFoundException;
import ru.itis.exception.UserNotFoundException;
import ru.itis.model.AnimalTypeEntity;
import ru.itis.model.PetEntity;
import ru.itis.model.UserEntity;
import ru.itis.repository.AnimalTypeRepository;
import ru.itis.repository.PetRepository;
import ru.itis.repository.UserRepository;
import ru.itis.service.AnimalTypeService;
import ru.itis.service.PetService;
import ru.itis.service.UserService;
import ru.itis.util.mapper.AnimalTypeMapper;
import ru.itis.util.mapper.PetMapper;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final UserRepository userRepository;

    private final AnimalTypeService animalTypeService;

    private final PetRepository petRepository;

    private final PetMapper petMapper;

    @Override
    public List<AnimalTypeResponse> getAllAnimalType() {
        return animalTypeService.getAllAnimalType();
    }

    @Override
    public UUID savePet(PetRequest petRequest) {
        PetEntity newPet = PetEntity.builder()
                .user(userRepository.findById(petRequest.getUserId()).orElseThrow(UserNotFoundException::new))
                .animalType(animalTypeService.getById(petRequest.getAnimalTypeId()))
                .name(petRequest.getName())
                .build();
        return petRepository.save(newPet).getId();
    }

    @Override
    public List<PetResponse> getAllPetByUser(UserEntity user) {
        return petMapper.toListResponse(petRepository.getAllByUser(user));
    }

    @Override
    public PetEntity getById(UUID id) {
        return petRepository.findById(id).orElseThrow(PetNotFoundException::new);
    }
}
