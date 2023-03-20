package ru.itis.service;

import ru.itis.dto.response.ServiceResponse;
import ru.itis.model.DepartmentEntity;

import java.util.List;

public interface ServiceService {
    List<ServiceResponse> getServicesByDepartment(DepartmentEntity department);
}
