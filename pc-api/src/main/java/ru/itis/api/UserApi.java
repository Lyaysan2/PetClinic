package ru.itis.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.request.AppointmentRequest;
import ru.itis.dto.response.AppointmentInfoResponse;
import ru.itis.dto.response.DoctorInfoResponse;
import ru.itis.dto.response.PetResponse;
import ru.itis.dto.response.UserInfoResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Tag(name = "User API", description = "get user pets, get user info")
@RequestMapping("/api/user")
public interface UserApi {

    @Operation(summary = "All user pet by user id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of user's pet received", content = {
                    @Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = PetResponse.class)))
            }),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @GetMapping(value = "/{user-id}/pet", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    List<PetResponse> getAllPet(@Parameter(description = "user id") @PathVariable("user-id") UUID userId);


    @Operation(summary = "User info by user id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User received", content = {
                    @Content(mediaType = "application/json", schema =
                    @Schema(implementation = UserInfoResponse.class))
            }),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @GetMapping(value = "/{user-id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    UserInfoResponse getUserInfo(@Parameter(description = "user id") @PathVariable("user-id") UUID userId);

    @Operation(summary = "Make appointment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "appointment created successfully", content = {
                    @Content(mediaType = "application/json", schema =
                    @Schema(implementation = AppointmentInfoResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "appointment request validation failed",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "not found", content = @Content)
    })
    @GetMapping(value = "/appointment", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    AppointmentInfoResponse makeAppointment(@Valid @RequestBody AppointmentRequest appointmentRequest);
}
