package ru.itis.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "user login request")
public class LoginRequest {

    @Email(message = "INVALID EMAIL")
    @NotBlank
    @Schema(description = "user email", example = "ivan@gmail.com", required = true)
    private String email;

    @NotBlank
    @Schema(description = "user password", example = "Abc123i", required = true)
    private String password;
}
