package ru.itis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dto.response.ServiceResponse;
import ru.itis.exception.DepartmentNotFoundException;
import ru.itis.model.DepartmentEntity;
import ru.itis.service.ServiceService;
import ru.itis.util.mapper.ServiceMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceMapper serviceMapper;

    @Override
    public List<ServiceResponse> getServicesByDepartment(DepartmentEntity department) {
        return serviceMapper.toListResponse(department.getServices().stream().toList());
    }
}
