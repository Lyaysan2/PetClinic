package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.TestApi;
import ru.itis.repository.PetRepository;
import ru.itis.repository.UserRepository;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TestController implements TestApi {

    private final PetRepository petRepository;

    @Override
    public String test() {
        return petRepository.findById(UUID.fromString("decd23c3-323e-0146-2303-96e6f043fa18")).get().getName();
    }
}
