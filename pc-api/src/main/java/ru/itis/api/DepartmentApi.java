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
import ru.itis.dto.response.DepartmentResponse;
import ru.itis.dto.response.DoctorInfoResponse;
import ru.itis.dto.response.DoctorResponse;
import ru.itis.dto.response.ServiceResponse;

import java.util.List;
import java.util.UUID;

@Tag(name = "Department API", description = "list of departments / list of services by department")
@RequestMapping("/api/department")
public interface DepartmentApi {

    @Operation(summary = "list of department and number of services in each")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of department received", content = {
                    @Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = DepartmentResponse.class)))
            })
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    List<DepartmentResponse> getAllDepartment();

    @Operation(summary = "list of services by department id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of services received", content = {
                    @Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = ServiceResponse.class)))
            }),
            @ApiResponse(responseCode = "404", description = "Department not found", content = @Content)
    })
    @GetMapping(value = "/{department-id}/service", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    List<ServiceResponse> getServicesByDepartment(@Parameter(description = "department id") @PathVariable("department-id") UUID departmentId);

    @Operation(summary = "list of doctors by department id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of doctors received", content = {
                    @Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = DoctorResponse.class)))
            }),
            @ApiResponse(responseCode = "404", description = "Department not found", content = @Content)
    })
    @GetMapping(value = "/{department-id}/doctor", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    List<DoctorResponse> getDoctorsByDepartment(@Parameter(description = "department id") @PathVariable("department-id") UUID departmentId);

//    @GetMapping("/jwt")
//    @ResponseStatus(HttpStatus.OK)
//    String testJwt();
}
