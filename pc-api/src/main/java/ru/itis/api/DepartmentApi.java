package ru.itis.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.itis.dto.response.DepartmentResponse;

import java.util.List;

@Tag(name = "Department API", description = "get list of departments")
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

//    @GetMapping("/jwt")
//    @ResponseStatus(HttpStatus.OK)
//    String testJwt();
}
