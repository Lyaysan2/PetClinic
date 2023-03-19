package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.DoctorEntity;

import java.util.UUID;

public interface DoctorRepository extends JpaRepository<DoctorEntity, UUID> {
}
