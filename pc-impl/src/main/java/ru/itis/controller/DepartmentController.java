package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.DepartmentApi;
import ru.itis.dto.response.DepartmentResponse;
import ru.itis.repository.DepartmentRepository;
import ru.itis.repository.PetRepository;
import ru.itis.repository.ServiceRepository;
import ru.itis.service.DepartmentService;
import ru.itis.util.mapper.DepartmentMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentController implements DepartmentApi {

    private final DepartmentService departmentService;

    @Override
    public List<DepartmentResponse> getAllDepartment() {
        return departmentService.getAllDirection();
    }

//    @Override
//    public String testJwt() {
//        return "JWT success";
//    }
}
