package ru.itis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.dto.enums.State;
import ru.itis.dto.request.LoginRequest;
import ru.itis.dto.request.SignUpRequest;
import ru.itis.dto.response.PetResponse;
import ru.itis.dto.response.UserInfoResponse;
import ru.itis.dto.response.UserResponse;
import ru.itis.dto.response.UserTokenResponse;
import ru.itis.exception.UnauthorizedException;
import ru.itis.exception.UserExistException;
import ru.itis.exception.UserNotFoundException;
import ru.itis.model.UserEntity;
import ru.itis.repository.UserRepository;
import ru.itis.service.PetService;
import ru.itis.service.UserService;
import ru.itis.util.mapper.UserMapper;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    private final PetService petService;

    @Override
    public UUID signUpUser(SignUpRequest signUpRequest) {
        if (findByEmail(signUpRequest.getEmail()).isPresent()){
            throw new UserExistException();
        }
        UserEntity user = userMapper.toEntity(signUpRequest);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setState(State.CONFIRMED);

        return saveUser(user);
    }

    @Override
    public UserTokenResponse login(LoginRequest loginRequest) {
        return userRepository.findByEmail(loginRequest.getEmail())
                .filter(user -> passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()))
                .map(userMapper::toTokenResponse)
                .orElseThrow(() -> new UnauthorizedException("Failes to log in: " + loginRequest.getEmail()));
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity getByEmail(String email) {
        return findByEmail(email).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public UUID saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity).getId();
    }

    @Override
    public UserResponse getUserResponse(String email) {
        return userMapper.toTokenInfoResponse(getByEmail(email));
    }

    @Override
    public UserEntity getById(UUID id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<PetResponse> getAllPet(UUID userId) {
        return petService.getAllPetByUser(getById(userId));
    }

    @Override
    public UserInfoResponse getUserInfo(UUID userId) {
        return userMapper.toInfoResponse(getById(userId));
    }

}
