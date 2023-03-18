package ru.itis.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "access, refresh token request")
public class TokenCoupleDtoRequest {

    @NotBlank
    @Schema(description = "access token", required = true)
    private String accessToken;

    @NotBlank
    @Schema(description = "refresh token", required = true)
    private String refreshToken;
}
