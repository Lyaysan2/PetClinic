package ru.itis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dto.response.DoctorResponse;
import ru.itis.repository.DoctorRepository;
import ru.itis.service.DoctorService;
import ru.itis.util.mapper.DoctorMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    private final DoctorMapper doctorMapper;

    @Override
    public List<DoctorResponse> getAllDoctors() {
        return doctorMapper.toListResponse(doctorRepository.findAll());
    }
}
