package ru.itis.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import ru.itis.dto.response.ServiceResponse;
import ru.itis.model.ServiceEntity;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ServiceMapper {

    ServiceResponse toResponse(ServiceEntity service);

    List<ServiceResponse> toListResponse(List<ServiceEntity> serviceEntityList);
}
