package com.proyectoback.proyectoBack.entitys;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    
    @Column(columnDefinition = "TEXT")
    private String description;
    private int points;

    

    @ManyToOne
    @JoinColumn(name = "watcher_id")
    private Watcher watcher;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
    
    @OneToOne(mappedBy = "challenge", cascade = CascadeType.ALL)
    private Video videos;
}
