package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.UserApi;
import ru.itis.dto.response.PetResponse;
import ru.itis.dto.response.UserInfoResponse;
import ru.itis.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public List<PetResponse> getAllPet(UUID userId) {
        return userService.getAllPet(userId);
    }

    @Override
    public UserInfoResponse getUserInfo(UUID userId) {
        return userService.getUserInfo(userId);
    }
}
