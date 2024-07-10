package com.proyectoback.proyectoBack.entitys;


<<<<<<< HEAD
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

=======

import com.fasterxml.jackson.annotation.JsonManagedReference;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
>>>>>>> 0ed99e71df9ff8158330b7bc5a81d31c816dbe97
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
<<<<<<< HEAD
import jakarta.persistence.PrePersist;
=======
import jakarta.persistence.OneToOne;
>>>>>>> 0ed99e71df9ff8158330b7bc5a81d31c816dbe97
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
<<<<<<< HEAD

    @Column(columnDefinition = "TEXT")
    private String description;

    private int points;

    private String videoUrl;
=======
    @Column(columnDefinition = "TEXT")
    private String description;

    private int points
>>>>>>> 0ed99e71df9ff8158330b7bc5a81d31c816dbe97

    @ManyToOne
    @JoinColumn(name = "watcher_id")
    @JsonManagedReference
    private Watcher watcher;

    @ManyToOne
    @JoinColumn(name = "player_id")
    @JsonManagedReference
    private Player player;
    
<<<<<<< HEAD
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    
    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }
=======
    @OneToOne(mappedBy = "challenge", cascade = CascadeType.ALL)
    private Video videos;
>>>>>>> 0ed99e71df9ff8158330b7bc5a81d31c816dbe97
}


