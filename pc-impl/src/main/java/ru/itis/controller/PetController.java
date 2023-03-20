package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.PetApi;
import ru.itis.dto.request.PetRequest;
import ru.itis.dto.response.AnimalTypeResponse;
import ru.itis.service.PetService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PetController implements PetApi {

    private final PetService petService;

    @Override
    public List<AnimalTypeResponse> getAllAnimalType() {
        return petService.getAllAnimalType();
    }

    @Override
    public UUID createPet(PetRequest petRequest) {
        return petService.savePet(petRequest);
    }
}
