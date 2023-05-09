package ru.itis.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Tag(name = "File API", description = "upload photo / get photo")
@RequestMapping("/api/files")
public interface FileApi {

    @Operation(summary = "Upload doctor's photo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "File uploaded successfully"),
            @ApiResponse(responseCode = "400", description = "Incorrect type of file", content = @Content)
    })
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    UUID uploadFile(@Parameter(description = "doctor's photo") @RequestParam("file") MultipartFile file,
                    @Parameter(description = "doctor id") @RequestParam("id") UUID doctorId);

    @Operation(summary = "Get photo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "File downloaded successfully", content = {
                    @Content(mediaType = "multipart/form-data", schema =
                    @Schema(implementation = Resource.class))
            }),
            @ApiResponse(responseCode = "404", description = "File not found", content = @Content)
    })
    @GetMapping(value = "/{file-id}", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Resource> downloadFile(@Parameter(description = "file id") @PathVariable("file-id") UUID fileId);
}
