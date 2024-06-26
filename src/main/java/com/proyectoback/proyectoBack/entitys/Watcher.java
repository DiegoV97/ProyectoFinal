package com.proyectoback.proyectoBack.entitys;

import com.proyectoback.proyectoBack.Dto.UserDto;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter @Setter
public class Watcher extends User{
	
	 @OneToOne (mappedBy = "watcher")
	 private Challenge chellenge;
	 
	 
	 public Watcher(UserDto user) {
			this.username = user.getUsername();
			this.email = user.getEmail();
			this.password = user.getPassword();		
			}


	public Watcher() {
		super();
	}
	 
	 
}
