package ru.itis.service;

import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    String saveFileToStorage(MultipartFile file);

    GridFsResource getFileById(String id);
}
