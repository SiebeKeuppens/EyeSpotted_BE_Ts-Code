package com.faros.EyeSpotted.repository;

import com.faros.EyeSpotted.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long> {
    List<Animal>findAll();
}
