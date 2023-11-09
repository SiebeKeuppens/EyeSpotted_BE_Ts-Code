package com.faros.EyeSpotted.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Sighting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "creationtime")
    private Date creationtime;

    @ManyToOne
    @JoinColumn(name = "expeditiontargetid")
    private Expeditiontarget expeditiontarget;


}
