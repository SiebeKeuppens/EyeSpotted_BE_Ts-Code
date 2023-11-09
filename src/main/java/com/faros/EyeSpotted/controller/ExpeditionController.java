package com.faros.EyeSpotted.controller;

import com.faros.EyeSpotted.model.Expedition;
import com.faros.EyeSpotted.model.Tag;
import com.faros.EyeSpotted.service.ExpeditionService;
import com.faros.EyeSpotted.service.TagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/expeditions")
public class ExpeditionController {
    private ExpeditionService expeditionService = null;
    public ExpeditionController(ExpeditionService expeditionService) {
        this.expeditionService = expeditionService;
    }

    @GetMapping()
    public List<Expedition> getAllExpeditions() {
        return expeditionService.getAllExpeditions();
    }
}
