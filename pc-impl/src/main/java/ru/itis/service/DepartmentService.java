package ru.itis.service;

import ru.itis.dto.response.DepartmentResponse;

import java.util.List;

public interface DepartmentService {

    List<DepartmentResponse> getAllDirection();
}
