package ru.itis.service.impl;

import com.mongodb.client.gridfs.model.GridFSFile;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.exception.FileException;
import ru.itis.exception.FileStorageNotFoundException;
import ru.itis.service.FileStorageService;

import java.io.IOException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FileStorageServiceImpl implements FileStorageService {

    @Autowired
    private GridFsTemplate template;

    @Autowired
    private GridFsOperations gridFsOperations;

    @Override
    public String saveFileToStorage(MultipartFile file) {
        try {
            if (Objects.nonNull(file.getOriginalFilename())){
                return template.store(file.getInputStream(), file.getOriginalFilename()).toString();
            } else {
                throw new FileException("missing file name");
            }
        } catch (IOException exception){
            throw new FileException("file uploaded incorrectly");
        }
    }

    @Override
    public GridFsResource getFileById(String id) {
        GridFSFile file = template.findOne(Query.query(Criteria.where("_id").is(id)));
        if (Objects.nonNull(file)){
            return gridFsOperations.getResource(file);
        } else {
            throw new FileStorageNotFoundException(id);
        }
    }
}
