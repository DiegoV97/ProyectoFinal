package com.proyectoback.proyectoBack.entitys;

import java.util.List;


import com.proyectoback.proyectoBack.Dto.UserDto;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter @Setter
public class Player extends User{
 

private int points;

 @OneToMany (mappedBy = "player")
 private List<Challenge> chellenge;
 
 public Player(UserDto user) {
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.password = user.getPassword();
		}

public Player() {
	super();
}
 
 
}
