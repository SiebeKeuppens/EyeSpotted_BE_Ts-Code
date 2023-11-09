package com.faros.EyeSpotted.repository;

import com.faros.EyeSpotted.model.Expedition;
import com.faros.EyeSpotted.model.Expeditiontarget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpeditionTargetRepository extends JpaRepository<Expeditiontarget,Long> {
    List<Expeditiontarget> findAll();
}

