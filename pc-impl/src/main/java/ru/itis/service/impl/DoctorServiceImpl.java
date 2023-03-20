package ru.itis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dto.response.DoctorInfoResponse;
import ru.itis.dto.response.DoctorResponse;
import ru.itis.exception.DepartmentNotFoundException;
import ru.itis.exception.DoctorNotFoundException;
import ru.itis.model.DepartmentEntity;
import ru.itis.repository.DoctorRepository;
import ru.itis.service.DoctorService;
import ru.itis.util.mapper.DoctorMapper;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    private final DoctorMapper doctorMapper;

    @Override
    public List<DoctorResponse> getAllDoctors() {
        return doctorMapper.toListResponse(doctorRepository.findAll());
    }

    @Override
    public DoctorInfoResponse getDoctorById(UUID doctorId) {
        return doctorMapper.toInfoResponse(doctorRepository.findById(doctorId).orElseThrow(DoctorNotFoundException::new));
    }

    @Override
    public List<DoctorResponse> getDoctorsByDepartment(DepartmentEntity departmentEntity) {
        return doctorMapper.toListResponse(departmentEntity.getDoctors().stream().toList());
    }
}
