package ru.itis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.dto.response.FileResponse;
import ru.itis.exception.FileInfoNotFoundException;
import ru.itis.model.FileInfoEntity;
import ru.itis.repository.FileInfoRepository;
import ru.itis.service.DoctorService;
import ru.itis.service.FileService;
import ru.itis.service.FileStorageService;
import ru.itis.util.mapper.FileMapper;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final DoctorService doctorService;

    private final FileStorageService fileStorageService;

    private final FileInfoRepository fileInfoRepository;

    private final FileMapper fileMapper;

    @Override
    public UUID saveFile(MultipartFile multipartFile, UUID doctorId) {
        FileInfoEntity fileInfoEntity = fileMapper.toEntity(multipartFile, fileStorageService.saveFileToStorage(multipartFile));
        saveFileInfo(fileInfoEntity);
        doctorService.uploadDoctorPhoto(doctorId, fileInfoEntity);
        return fileInfoEntity.getId();
    }

    @Override
    public void saveFileInfo(FileInfoEntity fileInfo) {
        fileInfoRepository.save(fileInfo);
    }

    @Override
    public FileResponse downloadFile(UUID id) {
        FileInfoEntity fileInfo = getById(id);
        return FileResponse.builder()
                .mediaType(MediaType.valueOf(fileInfo.getType()))
                .size(fileInfo.getSize())
                .resource(fileStorageService.getFileById(fileInfo.getFileMongoDb()))
                .build();
    }

    @Override
    public FileInfoEntity getById(UUID id) {
        return fileInfoRepository.findById(id).orElseThrow(() -> {
            throw new FileInfoNotFoundException(id);
        });
    }
}
