package com.faros.EyeSpotted.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Expeditiontarget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "animalid")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "expeditionid")
    private Expedition expedition;

}
