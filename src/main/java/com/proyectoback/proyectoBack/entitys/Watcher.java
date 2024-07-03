package com.proyectoback.proyectoBack.entitys;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.proyectoback.proyectoBack.Dto.UserDto;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter @Setter
public class Watcher extends User{
	
	 @OneToMany (mappedBy = "watcher")
	 @JsonBackReference
	 private List<Challenge> challenges ;
	 
	 
	 public Watcher(UserDto user) {
			this.username = user.getUsername();
			this.email = user.getEmail();
			this.password = user.getPassword();		
			}


	public Watcher() {
		super();
	}
	 
	 
}
