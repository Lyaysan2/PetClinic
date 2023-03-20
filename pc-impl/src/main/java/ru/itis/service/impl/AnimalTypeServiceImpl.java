package ru.itis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dto.response.AnimalTypeResponse;
import ru.itis.exception.AnimalTypeNotFoundException;
import ru.itis.model.AnimalTypeEntity;
import ru.itis.repository.AnimalTypeRepository;
import ru.itis.service.AnimalTypeService;
import ru.itis.util.mapper.AnimalTypeMapper;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnimalTypeServiceImpl implements AnimalTypeService {

    private final AnimalTypeRepository animalTypeRepository;

    private final AnimalTypeMapper animalTypeMapper;

    @Override
    public AnimalTypeEntity getById(UUID id) {
        return animalTypeRepository.findById(id).orElseThrow(AnimalTypeNotFoundException::new);
    }

    @Override
    public List<AnimalTypeResponse> getAllAnimalType() {
        return animalTypeMapper.toListResponse(animalTypeRepository.findAll());
    }
}
