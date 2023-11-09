package com.faros.EyeSpotted.controller;

import com.faros.EyeSpotted.model.Animal;
import com.faros.EyeSpotted.model.Tag;
import com.faros.EyeSpotted.service.AnimalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping()
    public List<Animal> getALlAnimals() {
        return animalService.getAllAnimals();
    }
}
