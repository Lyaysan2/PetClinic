package ru.itis.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import ru.itis.dto.response.DoctorResponse;
import ru.itis.model.DoctorEntity;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DoctorMapper {

    DoctorResponse toResponse(DoctorEntity doctor);

    List<DoctorResponse> toListResponse(List<DoctorEntity> doctorEntityList);
}
