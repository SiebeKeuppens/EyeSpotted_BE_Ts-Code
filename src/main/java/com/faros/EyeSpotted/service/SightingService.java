package com.faros.EyeSpotted.service;

import com.faros.EyeSpotted.model.Sighting;
import com.faros.EyeSpotted.repository.SightingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SightingService {
    private final SightingRepository sightingRepository;

    public SightingService(SightingRepository sightingRepository) {
        this.sightingRepository = sightingRepository;
    }


    List<Sighting> getAllSightings() {return sightingRepository.findAll();}
}
