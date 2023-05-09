package ru.itis.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "File information and binary file")
public class FileResponse {

    @Schema(description = "file size", example = "4933379")
    private Long size;

    @Schema(description = "file media type", example = "image/jpeg")
    private MediaType mediaType;

    private Resource resource;
}
