package ru.itis.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import ru.itis.security.details.AccountUserDetails;
import ru.itis.service.UserService;

import java.util.UUID;

@Component("userSecurity")
@RequiredArgsConstructor
public class UserSecurity {

    private final UserService userService;

    public boolean hasUserId(Authentication authentication, UUID userId) {
        return userService.getByEmail(((AccountUserDetails) authentication.getPrincipal()).getUsername()).getId()
                .equals(userId);
    }
}
