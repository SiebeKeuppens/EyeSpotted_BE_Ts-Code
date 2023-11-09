package com.faros.EyeSpotted.service;

import com.faros.EyeSpotted.model.Animal;
import com.faros.EyeSpotted.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }
}
