package ru.itis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dto.response.ServiceResponse;
import ru.itis.exception.DepartmentNotFoundException;
import ru.itis.exception.ServiceNotFoundException;
import ru.itis.model.DepartmentEntity;
import ru.itis.model.ServiceEntity;
import ru.itis.repository.ServiceRepository;
import ru.itis.service.ServiceService;
import ru.itis.util.mapper.ServiceMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceMapper serviceMapper;
    private final ServiceRepository serviceRepository;

    @Override
    public List<ServiceResponse> getServicesByDepartment(DepartmentEntity department) {
        return serviceMapper.toListResponse(new ArrayList<>(department.getServices()));
    }

    @Override
    public ServiceEntity getById(UUID id) {
        return serviceRepository.findById(id).orElseThrow(ServiceNotFoundException::new);
    }
}
