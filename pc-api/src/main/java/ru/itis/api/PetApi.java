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
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.request.PetRequest;
import ru.itis.dto.response.AnimalTypeResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Tag(name = "Pet API", description = "")
@RequestMapping("/api/pet")
public interface PetApi {

    @Operation(summary = "All animal type list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of animal type received", content = {
                    @Content(mediaType = "application/json", array =
                    @ArraySchema(schema = @Schema(implementation = AnimalTypeResponse.class)))
            })
    })
    @GetMapping(value = "/type", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    List<AnimalTypeResponse> getAllAnimalType();

    @Operation(summary = "Create pet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pet created successfully"),
            @ApiResponse(responseCode = "400", description = "Pet request validation failed",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User or animal type not found", content = @Content)
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    UUID createPet(@Valid @RequestBody PetRequest petRequest);
}
