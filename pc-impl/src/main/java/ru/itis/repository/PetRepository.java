package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.PetEntity;

import java.util.UUID;

public interface PetRepository extends JpaRepository<PetEntity, UUID> {
}
