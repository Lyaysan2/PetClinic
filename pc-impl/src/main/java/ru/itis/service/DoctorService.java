package ru.itis.service;

import ru.itis.dto.response.DoctorInfoResponse;
import ru.itis.dto.response.DoctorResponse;
import ru.itis.dto.response.TimeSlotResponse;
import ru.itis.model.DepartmentEntity;
import ru.itis.model.DoctorEntity;
import ru.itis.model.FileInfoEntity;

import java.util.List;
import java.util.UUID;

public interface DoctorService {

    DoctorInfoResponse getDoctorInfoById(UUID doctorId);

    List<DoctorResponse> getDoctorsByDepartment(DepartmentEntity departmentEntity);

    List<TimeSlotResponse> getTimeByDoctorId(UUID doctorId);

    DoctorEntity getById(UUID id);

    void uploadDoctorPhoto(UUID doctorId, FileInfoEntity fileInfoEntity);
}
