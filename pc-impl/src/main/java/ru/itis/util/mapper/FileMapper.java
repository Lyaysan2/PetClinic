package ru.itis.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.model.FileInfoEntity;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface FileMapper {

//    @Mapping(target = "name", source = "cv.cvFile.originalName")
//    @Mapping(target = "size", source = "cv.cvFile.size")
//    FileInfoResponse toResponse(CVEntity cv);
//
//    @Mapping(target = "name", source = "fileInfo.originalName")
//    @Mapping(target = "size", source = "fileInfo.size")
//    FileInfoResponse toResponse(FileInfoEntity fileInfo);

    @Mapping(target = "originalFileName", source = "multipartFile.originalFilename")
    @Mapping(target = "type", source = "multipartFile.contentType")
    @Mapping(target = "size", source = "multipartFile.size")
    @Mapping(target = "fileMongoDb", source = "storageId")
    FileInfoEntity toEntity(MultipartFile multipartFile, String storageId);
}
