package ru.itis.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "access, refresh token response")
public class TokenCoupleResponse {

    @Schema(description = "access token", required = true)
    private String accessToken;

    @Schema(description = "refresh token", required = true)
    private String refreshToken;

    @Schema(description = "access token expiration date")
    private Instant accessTokenExpirationDate;
}
