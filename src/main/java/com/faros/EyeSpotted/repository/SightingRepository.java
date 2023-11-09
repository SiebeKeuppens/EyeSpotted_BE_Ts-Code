package com.faros.EyeSpotted.repository;

import com.faros.EyeSpotted.model.Sighting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SightingRepository extends JpaRepository<Sighting,Long> {
    Sighting getSightingById(Long Id);
    List<Sighting> findAll();
}
