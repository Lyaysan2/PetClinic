package ru.itis.service;

import org.springframework.web.multipart.MultipartFile;
import ru.itis.dto.response.FileResponse;
import ru.itis.model.FileInfoEntity;

import java.util.UUID;

public interface FileService {

    UUID saveFile(MultipartFile file, UUID doctorId);

    void saveFileInfo(FileInfoEntity fileInfo);

    FileResponse downloadFile(UUID id);

    FileInfoEntity getById(UUID id);

}
