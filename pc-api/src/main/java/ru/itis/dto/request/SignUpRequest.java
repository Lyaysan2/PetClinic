package ru.itis.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.validation.annotation.SamePasswords;
import ru.itis.validation.annotation.ValidPassword;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@SamePasswords(passwords = {"password", "repeatedPassword"})
@Schema(description = "user sign up request")
public class SignUpRequest {

    @Schema(description = "user first name", example = "ivan", required = true)
    @Size(min = 2, max = 15, message = "MINIMUM_NAME_SIZE: {min}, MAXIMUM_NAME_SIZE: {max}")
    private String firstName;

    @Schema(description = "user last name", example = "ivanov", required = true)
    @Size(min = 4, max = 20, message = "MINIMUM_LAST_NAME_SIZE: {min}, MAXIMUM_LAST_NAME_SIZE: {max}")
    private String lastName;

    @Email(message = "INVALID_EMAIL")
    @NotBlank
    @Schema(description = "user email", example = "ivan@gmail.com", required = true)
    private String email;

    @ValidPassword
    @Schema(description = "password", example = "Abc123i", required = true)
    private String password;

    @Schema(description = "repeat password", example = "Abc123i", required = true)
    private String repeatedPassword;

    @Schema(description = "user phone", example = "+79510654781", required = true)
    @Pattern(regexp="\\+\\d{11}", message = "PHONE_NUMBER_INVALID")
    private String phone;
}
