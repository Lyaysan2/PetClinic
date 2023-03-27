package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.PetEntity;
import ru.itis.model.UserEntity;

import java.util.List;
import java.util.UUID;

public interface PetRepository extends JpaRepository<PetEntity, UUID> {

    List<PetEntity> getAllByUser(UserEntity userEntity);
}
