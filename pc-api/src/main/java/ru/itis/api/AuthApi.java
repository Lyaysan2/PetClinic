package ru.itis.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.itis.dto.request.LoginRequest;
import ru.itis.dto.request.SignUpRequest;
import ru.itis.dto.response.TokenCoupleResponse;

import javax.validation.Valid;
import java.util.UUID;

@Tag(name = "Auth API", description = "sign up / login user")
@RequestMapping("/api/auth")
public interface AuthApi {

    @Operation(summary = "Sign up user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created", content = {
                    @Content(mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "400", description = "Validation failed", content = @Content),
            @ApiResponse(responseCode = "404", description = "User already exist", content = @Content)
    })
    @PostMapping(value = "/sign-up", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    UUID signUp(@Valid @RequestBody SignUpRequest signUpRequest);


    @Operation(summary = "Login user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User logged in", content = {
                    @Content(mediaType = "application/json", schema =
                    @Schema(implementation = TokenCoupleResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Validation failed", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    TokenCoupleResponse login(@Valid @RequestBody LoginRequest loginRequest);
}
