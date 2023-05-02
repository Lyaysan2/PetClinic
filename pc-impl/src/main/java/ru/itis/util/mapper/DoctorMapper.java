package ru.itis.util.mapper;

import org.mapstruct.*;
import ru.itis.dto.response.DoctorInfoResponse;
import ru.itis.dto.response.DoctorResponse;
import ru.itis.model.DoctorEntity;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DoctorMapper {

    @Named(value = "toResponse")
    DoctorResponse toResponse(DoctorEntity doctor);

    @IterableMapping(qualifiedByName = "toResponse")
    List<DoctorResponse> toListResponse(List<DoctorEntity> doctorEntityList);

    @Mapping(target = "departmentId", source = "doctor.department.id")
    DoctorInfoResponse toInfoResponse(DoctorEntity doctor);
}
