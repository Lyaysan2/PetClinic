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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.itis.dto.response.DepartmentResponse;
import ru.itis.dto.response.DoctorInfoResponse;
import ru.itis.dto.response.DoctorResponse;
import ru.itis.dto.response.ServiceResponse;

import java.util.List;
import java.util.UUID;

@Tag(name = "Doctor API", description = "get list of doctors / get doctor")
@RequestMapping("/api/doctor")
public interface DoctorApi {

    @Operation(summary = "All doctors full name list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of doctors received", content = {
                    @Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = DoctorResponse.class)))
            })
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    List<DoctorResponse> getAllDoctors();

    @Operation(summary = "Doctor info by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Doctor received", content = {
                    @Content(mediaType = "application/json", schema =
                    @Schema(implementation = DoctorInfoResponse.class))
            }),
            @ApiResponse(responseCode = "404", description = "Doctor not found", content = @Content)
    })
    @GetMapping(value = "/{doctor-id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    DoctorInfoResponse getDoctorInfo(@Parameter(description = "doctor id") @PathVariable("doctor-id") UUID doctorId);

}
