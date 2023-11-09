package com.faros.EyeSpotted.controller;

import com.faros.EyeSpotted.service.TagService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
public class TagController {
private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }
}
