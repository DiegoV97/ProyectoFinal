package com.proyectoback.proyectoBack.entitys;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "TEXT")
    private String description;
    private int points;
    private String videoUrl;
<<<<<<< HEAD
    private int likes;
    
=======

>>>>>>> master
    @ManyToOne
    @JoinColumn(name = "watcher_id")
    private Watcher watcher;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
}
