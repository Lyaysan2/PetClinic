package ru.itis.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import ru.itis.dto.request.SignUpRequest;
import ru.itis.dto.response.UserResponse;
import ru.itis.dto.response.UserTokenResponse;
import ru.itis.model.UserEntity;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

    @Mapping(target = "role", expression = "java(ru.itis.dto.enums.Role.USER)")
    @Mapping(target = "state", expression = "java(ru.itis.dto.enums.State.NOT_CONFIRMED)")
    UserEntity toEntity(SignUpRequest signUpRequest);

    UserTokenResponse toTokenResponse(UserEntity user);

    UserResponse toTokenInfoResponse(UserEntity user);
}
