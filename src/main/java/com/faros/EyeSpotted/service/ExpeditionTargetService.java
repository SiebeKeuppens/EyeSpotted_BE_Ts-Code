package com.faros.EyeSpotted.service;

import com.faros.EyeSpotted.model.Expeditiontarget;
import com.faros.EyeSpotted.repository.ExpeditionRepository;
import com.faros.EyeSpotted.repository.ExpeditionTargetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpeditionTargetService {
    private ExpeditionTargetRepository expeditionTargetRepository = null;


    public ExpeditionTargetService(ExpeditionTargetRepository expeditionTargetRepository) {
        this.expeditionTargetRepository = expeditionTargetRepository;
    }

    public List<Expeditiontarget> getAllExpeditionTargets() {return expeditionTargetRepository.findAll();}
}