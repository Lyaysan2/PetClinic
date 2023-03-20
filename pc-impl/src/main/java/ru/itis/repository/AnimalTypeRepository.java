package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.AnimalTypeEntity;

import java.util.UUID;

public interface AnimalTypeRepository extends JpaRepository<AnimalTypeEntity, UUID> {
}
