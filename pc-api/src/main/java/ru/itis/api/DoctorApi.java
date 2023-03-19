package ru.itis.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.itis.dto.response.DoctorResponse;

import java.util.List;

@Tag(name = "Doctor API", description = "get list of doctors")
@RequestMapping("/api/doctor")
public interface DoctorApi {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    List<DoctorResponse> getAllDoctors();
}
