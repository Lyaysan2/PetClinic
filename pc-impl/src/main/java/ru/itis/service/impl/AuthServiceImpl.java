package ru.itis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.dto.request.LoginRequest;
import ru.itis.dto.request.SignUpRequest;
import ru.itis.dto.response.TokenCoupleResponse;
import ru.itis.service.AuthService;
import ru.itis.service.JwtTokenService;
import ru.itis.service.UserService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;

    private final JwtTokenService jwtTokenService;

    @Override
    @Transactional
    public UUID signUp(SignUpRequest signUpRequest) {
        return userService.signUpUser(signUpRequest);
    }

    @Override
    public TokenCoupleResponse login(LoginRequest loginRequest) {
        return jwtTokenService.generateTokenCouple(userService.login(loginRequest));
    }
}
