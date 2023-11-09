package com.faros.EyeSpotted.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    @Column(name = "imagedata")
    private byte[] imageData;

    @ManyToMany
    @JoinTable(
            name = "animaltag",
            joinColumns = @JoinColumn(name = "tagid"),
            inverseJoinColumns = @JoinColumn(name = "animalid"))
    private Set<Tag> tags;

}
