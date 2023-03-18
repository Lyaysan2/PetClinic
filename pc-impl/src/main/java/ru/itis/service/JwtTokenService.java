package ru.itis.service;

import ru.itis.dto.request.TokenCoupleDtoRequest;
import ru.itis.dto.response.TokenCoupleResponse;
import ru.itis.dto.response.UserResponse;
import ru.itis.dto.response.UserTokenResponse;
import ru.itis.model.RefreshTokenEntity;

import java.time.Instant;

public interface JwtTokenService {

    TokenCoupleResponse generateTokenCouple(UserTokenResponse userTokenResponse);

    String generateRefreshToken(UserTokenResponse userTokenResponse);

    String generateAccessToken(UserTokenResponse userTokenResponse);

    Instant getExpirationDateFromAccessToken(String accessToken);

    UserResponse getUserInfoByToken(String token);

    TokenCoupleResponse refreshTokens(TokenCoupleDtoRequest tokenCoupleDto);

    String verifyRefreshTokenExpiryDate(String token);

    RefreshTokenEntity getRefreshTokenById(String token);
}
