package com.faros.EyeSpotted.service;

import com.faros.EyeSpotted.model.Expedition;
import com.faros.EyeSpotted.repository.ExpeditionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpeditionService {
    private final ExpeditionRepository expeditionRepository;


    public ExpeditionService(ExpeditionRepository expeditionRepository) {
        this.expeditionRepository = expeditionRepository;
    }

    public List<Expedition> getAllExpeditions() {return expeditionRepository.findAll();}

    public void AddExpedition(Expedition expedition) {
        expeditionRepository.save(expedition);
    }
}
