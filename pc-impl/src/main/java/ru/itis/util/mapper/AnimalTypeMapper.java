package ru.itis.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import ru.itis.dto.response.AnimalTypeResponse;
import ru.itis.model.AnimalTypeEntity;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AnimalTypeMapper {

    AnimalTypeResponse toResponse(AnimalTypeEntity animalTypeEntity);

    List<AnimalTypeResponse> toListResponse(List<AnimalTypeEntity> animalTypeEntityList);
}
