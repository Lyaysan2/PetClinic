package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.api.FileApi;
import ru.itis.dto.response.FileResponse;
import ru.itis.service.FileService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class FileController implements FileApi {

    private final FileService fileService;

    @Override
    public UUID uploadFile(MultipartFile multipartFile, UUID doctorId) {
        return fileService.saveFile(multipartFile, doctorId);
    }

    @Override
    public ResponseEntity<Resource> downloadFile(UUID fileId) {
        FileResponse fileResponse = fileService.downloadFile(fileId);
        return ResponseEntity.ok()
                .contentType(fileResponse.getMediaType())
                .contentLength(fileResponse.getSize())
                .body(fileResponse.getResource());
    }
}
