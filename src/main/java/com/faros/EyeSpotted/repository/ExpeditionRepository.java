package com.faros.EyeSpotted.repository;

import com.faros.EyeSpotted.model.Expedition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpeditionRepository extends JpaRepository<Expedition,Long> {
    Expedition getExpeditionById(Long Id);
    List<Expedition> getExpeditionsByUserId(Long UserId);
    //List<ExpeditionTarget> getExpeditionTargetsByExpeditionId(Long Id);
}
