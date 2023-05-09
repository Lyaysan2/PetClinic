package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.FileInfoEntity;

import java.util.UUID;

public interface FileInfoRepository extends JpaRepository<FileInfoEntity, UUID> {
}
