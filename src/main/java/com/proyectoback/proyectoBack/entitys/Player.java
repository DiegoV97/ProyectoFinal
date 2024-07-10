package com.proyectoback.proyectoBack.entitys;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;

<<<<<<< HEAD
=======


import com.fasterxml.jackson.annotation.JsonManagedReference;

import com.fasterxml.jackson.annotation.JsonBackReference;


>>>>>>> 0ed99e71df9ff8158330b7bc5a81d31c816dbe97
import com.proyectoback.proyectoBack.Dto.UserDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity

public class Player extends User {
<<<<<<< HEAD
	
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
=======

    private int challengeCompleted;
    private int points;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Challenge> challenges;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "player",fetch = FetchType.LAZY)
    private List <Video> videos;

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

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }

    public int getChallengeCompleted() {
        return challengeCompleted;
    }

    public void setChallengeCompleted(int challengeCompleted) {
        this.challengeCompleted = challengeCompleted + this.challengeCompleted;
    }
}

>>>>>>> 0ed99e71df9ff8158330b7bc5a81d31c816dbe97
