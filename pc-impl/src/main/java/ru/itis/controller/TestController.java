package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.TestApi;

@RestController
@RequiredArgsConstructor
public class TestController implements TestApi {

    @Override
    public String test() {
        return "Hello!";
    }
}
