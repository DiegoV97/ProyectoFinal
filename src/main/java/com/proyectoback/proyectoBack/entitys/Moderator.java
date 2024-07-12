package com.proyectoback.proyectoBack.entitys;


import com.proyectoback.proyectoBack.Dto.UserDto;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Moderator extends User{

	   public Moderator(UserDto user) {
	        this.username = user.getUsername();
	        this.email = user.getEmail();
	        this.password = user.getPassword();
	    }

	public Moderator() {
		super();
	}
	   
	   
}
