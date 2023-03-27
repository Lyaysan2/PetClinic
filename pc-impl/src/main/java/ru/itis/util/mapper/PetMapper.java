package ru.itis.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import ru.itis.dto.response.PetResponse;
import ru.itis.model.PetEntity;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PetMapper {

    @Mapping(target = "animalType", source = "pet.animalType.name")
    PetResponse toResponse(PetEntity pet);

    List<PetResponse> toListResponse(List<PetEntity> petEntityList);
}
