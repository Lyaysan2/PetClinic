package ru.itis.service;

import ru.itis.dto.request.LoginRequest;
import ru.itis.dto.request.SignUpRequest;
import ru.itis.dto.response.PetResponse;
import ru.itis.dto.response.UserInfoResponse;
import ru.itis.dto.response.UserResponse;
import ru.itis.dto.response.UserTokenResponse;
import ru.itis.model.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    UUID signUpUser(SignUpRequest signUpRequest);

    UserTokenResponse login(LoginRequest loginRequest);

    Optional<UserEntity> findByEmail(String email);

    UserEntity getByEmail(String email);

    UUID saveUser(UserEntity userEntity);

    UserResponse getUserResponse(String email);

    UserEntity getById(UUID id);

    List<PetResponse> getAllPet(UUID userId);

    UserInfoResponse getUserInfo(UUID userId);
}
