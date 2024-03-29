package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByEmail(String email);
}
