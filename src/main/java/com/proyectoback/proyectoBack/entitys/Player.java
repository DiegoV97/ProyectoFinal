package com.proyectoback.proyectoBack.entitys;

import java.util.List;

import Dto.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
@Entity                      
public class Player extends User{
 
 public Player(UserDto user) {
	this.username = user.getUsername();
	this.email = user.getEmail();
	this.password = user.getPassword();
	
	 
		
	}
private int points;
 @OneToMany (mappedBy = "player")
 
 
}
