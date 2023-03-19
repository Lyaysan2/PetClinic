package ru.itis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dto.response.DepartmentResponse;
import ru.itis.model.DepartmentEntity;
import ru.itis.repository.DepartmentRepository;
import ru.itis.repository.ServiceRepository;
import ru.itis.service.DepartmentService;
import ru.itis.util.mapper.DepartmentMapper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final DepartmentMapper departmentMapper;

    @Override
    public List<DepartmentResponse> getAllDirection() {
        return departmentMapper.toListResponse(departmentRepository.findAll());
    }
}
