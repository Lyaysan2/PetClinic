package ru.itis.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Short information about user")
public class UserResponse {

    @Schema(description = "user id")
    private UUID id;

    @Schema(description = "user first name", example = "Иван")
    private String firstName;

    @Schema(description = "user last name", example = "Иванов")
    private String lastName;

    @Schema(description = "user email", example = "ivan@gmail.com")
    private String email;
}

