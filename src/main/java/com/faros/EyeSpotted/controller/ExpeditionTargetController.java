package com.faros.EyeSpotted.controller;

import com.faros.EyeSpotted.model.Expeditiontarget;
import com.faros.EyeSpotted.repository.ExpeditionTargetRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/expedition-targets")
public class ExpeditionTargetController {
    private ExpeditionTargetRepository expeditionTargetRepository = null;

    public ExpeditionTargetController(ExpeditionTargetRepository expeditionTargetRepository) {
        this.expeditionTargetRepository = expeditionTargetRepository;
    }

    @GetMapping()
    public List<Expeditiontarget> getAllExpeditionTargets() {
        return expeditionTargetRepository.findAll();
    }
}
