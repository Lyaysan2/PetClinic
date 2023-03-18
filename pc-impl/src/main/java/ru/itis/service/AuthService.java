package ru.itis.service;

import ru.itis.dto.request.LoginRequest;
import ru.itis.dto.request.SignUpRequest;
import ru.itis.dto.response.TokenCoupleResponse;

import java.util.UUID;

public interface AuthService {

    UUID signUp(SignUpRequest signUpRequest);

    TokenCoupleResponse login(LoginRequest loginRequest);
}
