package com.proyectoback.proyectoBack.entitys;





import com.fasterxml.jackson.annotation.JsonBackReference;
import com.proyectoback.proyectoBack.Dto.UserDto;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
@Entity

public class Player extends User{
 

private int points;

 @OneToOne (mappedBy = "player")
 @JsonBackReference
 private Challenge chellenge;
 
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

public Challenge getChellenge() {
	return chellenge;
}

public void setChellenge(Challenge chellenge) {
	this.chellenge = chellenge;
}
 
 
}
