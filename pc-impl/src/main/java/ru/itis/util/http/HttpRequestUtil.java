package ru.itis.util.http;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import ru.itis.exception.AuthenticationHeaderException;

import java.util.Objects;

@Slf4j
@UtilityClass
public class HttpRequestUtil {

    public String getTokenFromValidatedAuthorizationHeader(String header) {
        if (Objects.isNull(header)) {
            throw new AuthenticationHeaderException("Authorization token is missing");
        }
        if (!header.startsWith("BEARER")) {
            throw new AuthenticationHeaderException("Invalid authentication scheme found in Authorization header");
        }
        String token = StringUtils.removeStart(header, "BEARER").trim();
        if (StringUtils.isBlank(token)) {
            throw new AuthenticationHeaderException("Value of authorization token is empty");
        }
        return token;
    }
}
