package com.proyectoback.proyectoBack.entitys;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;

import com.proyectoback.proyectoBack.Dto.UserDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity

public class Player extends User {
	
    private int challengeCompleted;
    private int points;

 @OneToMany (mappedBy = "player")
 @JsonBackReference
 private List <Challenge> challenge;

 public List<Challenge> getChallenge() {
	return challenge;
}

public void setChallenge(List<Challenge> challenge) {
	this.challenge = challenge;
}

public Player(UserDto user) {
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.password = user.getPassword();
		}

    public Player() {
        super();
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points + this.points;
    }

    public int getChallengeCompleted() {
        return challengeCompleted;
    }

    public void setChallengeCompleted(int challengeCompleted) {
        this.challengeCompleted = challengeCompleted + this.challengeCompleted;
    }
}