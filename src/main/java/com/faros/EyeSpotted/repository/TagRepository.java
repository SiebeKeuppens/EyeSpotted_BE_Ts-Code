package com.faros.EyeSpotted.repository;

import com.faros.EyeSpotted.model.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository {
    List<Tag> findAll();
}
