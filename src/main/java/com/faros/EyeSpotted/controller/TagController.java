package com.faros.EyeSpotted.controller;

import com.faros.EyeSpotted.model.Tag;
import com.faros.EyeSpotted.service.TagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {
private TagService tagService = null;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping()
    public List<Tag> getTags() {
        return tagService.getAllTags();
    }
}
