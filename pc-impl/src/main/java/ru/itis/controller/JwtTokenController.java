package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.JwtTokenApi;
import ru.itis.dto.request.TokenCoupleDtoRequest;
import ru.itis.dto.response.TokenCoupleResponse;
import ru.itis.dto.response.UserResponse;
import ru.itis.service.JwtTokenService;

@RestController
@RequiredArgsConstructor
public class JwtTokenController implements JwtTokenApi {

    private final JwtTokenService jwtTokenService;

    @Override
    public UserResponse userInfoByToken(String token) {
        return jwtTokenService.getUserInfoByToken(token);
    }

    @Override
    public TokenCoupleResponse updateTokens(TokenCoupleDtoRequest tokenCoupleDto) {
        return jwtTokenService.refreshTokens(tokenCoupleDto);
    }
}
