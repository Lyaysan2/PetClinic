package ru.itis.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.dto.enums.Role;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "user response")
public class UserTokenResponse {

    @Schema(description = "user email")
    private String email;

    @Schema(description = "user role")
    private Role role;
}
