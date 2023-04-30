package ru.itis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.dto.response.DoctorInfoResponse;
import ru.itis.dto.response.DoctorResponse;
import ru.itis.dto.response.TimeSlotResponse;
import ru.itis.exception.DoctorNotFoundException;
import ru.itis.model.DepartmentEntity;
import ru.itis.model.DoctorEntity;
import ru.itis.model.TimeSlotEntity;
import ru.itis.repository.DoctorRepository;
import ru.itis.service.DoctorService;
import ru.itis.util.mapper.DoctorMapper;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    private final DoctorMapper doctorMapper;

    @Override
    public DoctorInfoResponse getDoctorInfoById(UUID doctorId) {
        return doctorMapper.toInfoResponse(getById(doctorId));
    }

    @Override
    public List<DoctorResponse> getDoctorsByDepartment(DepartmentEntity departmentEntity) {
        return doctorMapper.toListResponse(new ArrayList<>(departmentEntity.getDoctors()));
    }

    @Override
    public List<TimeSlotResponse> getTimeByDoctorId(UUID doctorId) {
        DoctorEntity doctor = doctorRepository.findById(doctorId).orElseThrow(DoctorNotFoundException::new);
        return doctor.getTimeSlots().stream()
                .filter(i -> i.getStartTime().compareTo(Instant.now()) > 0)
                .sorted(Comparator.comparing(TimeSlotEntity::getStartTime))
                .map(this::toTimeSlotResponse).collect(Collectors.toList());
    }

    @Override
    public DoctorEntity getById(UUID id) {
        return doctorRepository.findById(id).orElseThrow(DoctorNotFoundException::new);
    }

    private TimeSlotResponse toTimeSlotResponse(TimeSlotEntity timeSlotEntity) {
        return TimeSlotResponse.builder()
                .id(timeSlotEntity.getId())
                .date(timeSlotEntity.getDate())
                .startTime(timeSlotEntity.getStartTime().atZone(ZoneId.of("GMT+3")).toLocalTime()
                        .format(DateTimeFormatter.ofPattern("HH:mm")))
                .isBooked(timeSlotEntity.getIsBooked())
                .build();
    }
}
