package ru.itis.util.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.experimental.UtilityClass;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class HttpResponseUtil {

    public static void putExceptionInResponse(HttpServletRequest request, HttpServletResponse response,
                                              Exception exception, int exceptionStatus) throws IOException {

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(exceptionStatus);
        final Map<String, Object> body = new HashMap<>();
        body.put("status", exceptionStatus);
        body.put("error", "Unauthorized");
        body.put("message", exception.getMessage());
        body.put("path", request.getRequestURI());

        final ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), body);
    }
}