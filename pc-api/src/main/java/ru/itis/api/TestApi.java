package ru.itis.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/api/test")
public interface TestApi {

    @GetMapping("/db")
    @ResponseStatus(HttpStatus.OK)
    String test();

    @GetMapping("/jwt")
    @ResponseStatus(HttpStatus.OK)
    String testJwt();
}
