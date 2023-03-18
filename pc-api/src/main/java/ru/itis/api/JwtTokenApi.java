package ru.itis.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.request.TokenCoupleDtoRequest;
import ru.itis.dto.response.TokenCoupleResponse;
import ru.itis.dto.response.UserResponse;

import javax.validation.Valid;

@Tag(name = "JWT token API", description = "update tokens / get user info by token")
@RequestMapping("/api/token")
public interface JwtTokenApi {

    @Operation(summary = "User info by token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User info received", content = {
                    @Content(mediaType = "application/json", schema =
                    @Schema(implementation = UserResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Token invalid", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @GetMapping(value = "/user-info", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    UserResponse userInfoByToken(@Parameter(name = "User access token without bearer")
                                 @RequestParam(name = "token") String token);

    @Operation(summary = "Update tokens")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tokens updated", content = {
                    @Content(mediaType = "application/json", schema =
                    @Schema(implementation = TokenCoupleResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Token couple invalid", content = @Content)
    })
    @PostMapping(value = "/refresh", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    TokenCoupleResponse updateTokens(@Parameter(name = "Access and refresh tokens")
                                     @Valid @RequestBody TokenCoupleDtoRequest tokenCoupleDto);
}
