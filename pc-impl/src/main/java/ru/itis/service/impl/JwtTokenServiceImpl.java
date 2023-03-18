package ru.itis.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.itis.dto.request.TokenCoupleDtoRequest;
import ru.itis.dto.response.TokenCoupleResponse;
import ru.itis.dto.response.UserResponse;
import ru.itis.dto.response.UserTokenResponse;
import ru.itis.exception.AuthenticationHeaderException;
import ru.itis.exception.RefreshTokenNotFound;
import ru.itis.model.RefreshTokenEntity;
import ru.itis.model.UserEntity;
import ru.itis.repository.RefreshTokenRepository;
import ru.itis.service.JwtTokenService;
import ru.itis.service.UserService;

import java.time.Instant;
import java.util.*;

@Service
@RequiredArgsConstructor
public class JwtTokenServiceImpl implements JwtTokenService {

    @Value("${jwt.expiration.access.mills}")
    private long expirationAccessInMills;

    @Value("${jwt.expiration.refresh.mills}")
    private long expirationRefreshInMills;

    @Value("${jwt.secretKey}")
    private String jwtSecret;

    private final RefreshTokenRepository refreshTokenRepository;

    private final UserService userService;

    @Override
    public TokenCoupleResponse generateTokenCouple(UserTokenResponse userTokenResponse) {
        String accessToken = generateAccessToken(userTokenResponse);
        return TokenCoupleResponse.builder()
                .accessToken("BEARER".concat(StringUtils.SPACE).concat(accessToken))
                .refreshToken(generateRefreshToken(userTokenResponse))
                .accessTokenExpirationDate(getExpirationDateFromAccessToken(accessToken))
                .build();
    }

    @Override
    public String generateRefreshToken(UserTokenResponse userTokenResponse) {
        UserEntity user = userService.getByEmail(userTokenResponse.getEmail());
        UUID oldRefreshTokenId = null;
        if (Objects.nonNull(user.getRefreshToken())){
            oldRefreshTokenId = user.getRefreshToken().getId();
        }
        RefreshTokenEntity refreshToken = RefreshTokenEntity.builder()
                .expiryDate(Instant.now().plusMillis(expirationRefreshInMills))
                .build();
        refreshTokenRepository.save(refreshToken);
        user.setRefreshToken(refreshToken);
        userService.saveUser(user);
        if(Objects.nonNull(oldRefreshTokenId)){
            refreshTokenRepository.deleteById(oldRefreshTokenId);
        }
        return String.valueOf(refreshToken.getId());
    }

    @Override
    public String generateAccessToken(UserTokenResponse userTokenResponse) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(Claims.SUBJECT, userTokenResponse.getEmail());
        claims.put("ROLE", userTokenResponse.getRole());
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(Date.from(Instant.now().plusMillis(expirationAccessInMills)))
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    }

    @Override
    public Instant getExpirationDateFromAccessToken(String accessToken) {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(accessToken)
                    .getBody()
                    .getExpiration().toInstant();
        } catch (ExpiredJwtException e) {
            return e.getClaims().getExpiration().toInstant();
        }
    }

    @Override
    public UserResponse getUserInfoByToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(token).getBody();
            return userService.getUserResponse(claims.getSubject());
        } catch (ExpiredJwtException e) {
            throw new AuthenticationHeaderException("Token expired date error");
        }
    }

    @Override
    public TokenCoupleResponse refreshTokens(TokenCoupleDtoRequest tokenCoupleDto) {
        String accessToken = generateAccessToken(
                getUserTokenResponse(tokenCoupleDto.getRefreshToken()));

        return TokenCoupleResponse.builder()
                .accessToken("BEARER".concat(StringUtils.SPACE).concat(accessToken))
                .refreshToken(verifyRefreshTokenExpiryDate(tokenCoupleDto.getRefreshToken()))
                .accessTokenExpirationDate(getExpirationDateFromAccessToken(accessToken))
                .build();
    }

    private UserTokenResponse getUserTokenResponse(String token) {
        UserEntity user = getRefreshTokenById(token).getUser();
        return UserTokenResponse.builder()
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    @Override
    public String verifyRefreshTokenExpiryDate(String token) {
        System.err.println("refresh expiry date: " + getRefreshTokenById(token).getExpiryDate());
        System.err.println("now: " + Instant.now());
        System.err.println(getRefreshTokenById(token).getExpiryDate().compareTo(Instant.now()) < 0);
        if (getRefreshTokenById(token).getExpiryDate().compareTo(Instant.now()) < 0){
            return generateRefreshToken(getUserTokenResponse(token));
        }
        return token;
    }

    @Override
    public RefreshTokenEntity getRefreshTokenById(String token) {
        return refreshTokenRepository.findById(UUID.fromString(token))
                .orElseThrow(RefreshTokenNotFound::new);
    }
}
