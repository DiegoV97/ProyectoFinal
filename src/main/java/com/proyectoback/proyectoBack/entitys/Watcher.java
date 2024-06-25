package com.proyectoback.proyectoBack.entitys;

import java.util.List;

import Dto.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
@Entity
public class Watcher extends User{
	
	 @OneToMany (mappedBy = "watcher")
	 private List<Challenge> chellenge;
	 
	 
	 public Watcher(UserDto user) {
			this.username = user.getUsername();
			this.email = user.getEmail();
			this.password = user.getPassword();		
			}
}
