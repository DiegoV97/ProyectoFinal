package com.proyectoback.proyectoBack.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Getter@Setter

public class Video {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private String videoUrl;
	private int likes;
	
	@OneToOne
    @JoinColumn(name = "challenge_id")
	@JsonBackReference
    private Challenge challenge;
	
	@ManyToOne
    @JoinColumn(name = "player_id")
	@JsonBackReference
    private Player player;
	
}
