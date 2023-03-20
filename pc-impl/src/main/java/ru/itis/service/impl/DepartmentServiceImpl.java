package ru.itis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dto.response.DepartmentResponse;
import ru.itis.dto.response.DoctorResponse;
import ru.itis.dto.response.ServiceResponse;
import ru.itis.exception.DepartmentNotFoundException;
import ru.itis.repository.DepartmentRepository;
import ru.itis.service.DepartmentService;
import ru.itis.service.DoctorService;
import ru.itis.service.ServiceService;
import ru.itis.util.mapper.DepartmentMapper;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final DepartmentMapper departmentMapper;

    private final ServiceService serviceService;

    private final DoctorService doctorService;

    @Override
    public List<DepartmentResponse> getAllDirection() {
        return departmentMapper.toListResponse(departmentRepository.findAll());
    }

    @Override
    public List<ServiceResponse> getServicesByDepartment(UUID departmentId) {
        return serviceService.getServicesByDepartment(departmentRepository.findById(departmentId)
                .orElseThrow(DepartmentNotFoundException::new));
    }

    @Override
    public List<DoctorResponse> getDoctorsByDepartment(UUID departmentId) {
        return doctorService.getDoctorsByDepartment(departmentRepository.findById(departmentId)
                .orElseThrow(DepartmentNotFoundException::new));
    }
}
