package com.proyectoback.proyectoBack.entitys;





import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.proyectoback.proyectoBack.Dto.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity

public class Player extends User{
 

private int points;

 @OneToMany (mappedBy = "player")
 @JsonBackReference
 //private Challenge chellenge;
 private List<Challenge> challenges;
 public List<Challenge> getChallenges() {
	return challenges;
}

public void setChallenges(List<Challenge> challenges) {
	this.challenges = challenges;
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

//public Challenge getChellenge() {
	//return chellenge;
//}
//public void setChellenge(Challenge chellenge) {
	//this.chellenge = chellenge;
//}
 
}
