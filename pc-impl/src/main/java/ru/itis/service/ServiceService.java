package ru.itis.service;

import ru.itis.dto.response.ServiceResponse;
import ru.itis.model.DepartmentEntity;
import ru.itis.model.ServiceEntity;

import java.util.List;
import java.util.UUID;

public interface ServiceService {
    List<ServiceResponse> getServicesByDepartment(DepartmentEntity department);

    ServiceEntity getById(UUID id);
}
