package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.DepartmentApi;
import ru.itis.dto.response.DepartmentResponse;
import ru.itis.dto.response.DoctorResponse;
import ru.itis.dto.response.ServiceResponse;
import ru.itis.repository.DepartmentRepository;
import ru.itis.repository.PetRepository;
import ru.itis.repository.ServiceRepository;
import ru.itis.service.DepartmentService;
import ru.itis.util.mapper.DepartmentMapper;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class DepartmentController implements DepartmentApi {

    private final DepartmentService departmentService;

    @Override
    public List<DepartmentResponse> getAllDepartment() {
        return departmentService.getAllDirection();
    }

    @Override
    public List<ServiceResponse> getServicesByDepartment(UUID departmentId) {
        return departmentService.getServicesByDepartment(departmentId);
    }

    @Override
    public List<DoctorResponse> getDoctorsByDepartment(UUID departmentId) {
        return departmentService.getDoctorsByDepartment(departmentId);
    }

//    @Override
//    public String testJwt() {
//        return "JWT success";
//    }
}
