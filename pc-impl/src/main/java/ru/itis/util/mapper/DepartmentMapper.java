package ru.itis.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import ru.itis.dto.response.DepartmentResponse;
import ru.itis.model.DepartmentEntity;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DepartmentMapper {

    @Mapping(target = "name", source = "departmentEntity.name")
    @Mapping(target = "count", expression = "java(departmentEntity.getServices().size())")
    DepartmentResponse toResponse(DepartmentEntity departmentEntity);

    List<DepartmentResponse> toListResponse(List<DepartmentEntity> departmentEntityList);
}
