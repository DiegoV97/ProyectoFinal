package com.proyectoback.proyectoBack.entitys;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.proyectoback.proyectoBack.Dto.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;



@Entity

public class Player extends User{
 

private int points;
private int challengeCompleted;

 @OneToMany (mappedBy = "player")
 @JsonBackReference
 private List<Challenge> challenge;
 
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

public List<Challenge> getChallenge() {
	return challenge;
}

public void setChallenge(List<Challenge> challenge) {
	this.challenge = challenge;
}

public int getChallengeCompleted() {
	return challengeCompleted;
}

public void setChallengeCompleted(int challengeCompleted) {
	this.challengeCompleted = challengeCompleted + this.challengeCompleted;
}


 
}
