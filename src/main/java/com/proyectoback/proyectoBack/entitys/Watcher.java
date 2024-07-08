package com.proyectoback.proyectoBack.entitys;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.proyectoback.proyectoBack.Dto.UserDto;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter @Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Watcher extends User{
	
	private int proposedChallenge;
	
	 @OneToMany(mappedBy = "watcher", fetch = FetchType.LAZY)
	    private List<Challenge> challenges;
	 
	 
	 public Watcher(UserDto user) {
			this.username = user.getUsername();
			this.email = user.getEmail();
			this.password = user.getPassword();		
			}


	public Watcher() {
		super();
	}
	public int getProposedChallenge() {
		return proposedChallenge;
	}


	public void setProposedChallenge(int proposedChallenge) {
		this.proposedChallenge = proposedChallenge + this.proposedChallenge;
	}
	 
	 
}