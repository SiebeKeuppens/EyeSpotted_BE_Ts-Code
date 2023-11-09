package com.faros.EyeSpotted.controller;

import com.faros.EyeSpotted.model.Expedition;
import com.faros.EyeSpotted.security.EyeSpottedSecurityContextHolder;
import com.faros.EyeSpotted.service.ExpeditionService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @PostMapping()
    public ModelAndView AddExpedition(@RequestBody Expedition expedition) {
        ModelAndView response = new ModelAndView("redirect:/expedition/");
        expedition.setUser(EyeSpottedSecurityContextHolder.getUser());
        expeditionService.AddExpedition(expedition);
        return response;
    }
}
