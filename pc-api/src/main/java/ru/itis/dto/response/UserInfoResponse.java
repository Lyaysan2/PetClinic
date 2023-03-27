package ru.itis.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "user info for personal profile")
public class UserInfoResponse {

    @Schema(description = "user first name", example = "ivan")
    private String firstName;

    @Schema(description = "user last name", example = "ivanov")
    private String lastName;

    @Schema(description = "user email", example = "ivan@gmail.com")
    private String email;

    @Schema(description = "user phone", example = "+79510654781")
    private String phone;
}
