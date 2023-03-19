package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.AuthApi;
import ru.itis.dto.request.LoginRequest;
import ru.itis.dto.request.SignUpRequest;
import ru.itis.dto.response.TokenCoupleResponse;
import ru.itis.service.AuthService;
import ru.itis.service.DepartmentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {

    private final AuthService authService;

    @Override
    public UUID signUp(SignUpRequest signUpRequest) {
        return authService.signUp(signUpRequest);
    }

    @Override
    public TokenCoupleResponse login(LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    private final DepartmentService departmentService;
//
//    @Override
//    public List<String> getAllDirection() {
//        return departmentService.getAllDirection();
//    }
}
