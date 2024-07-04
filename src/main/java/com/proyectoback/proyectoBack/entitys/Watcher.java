package com.proyectoback.proyectoBack.entitys;

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

public class Watcher extends User{
	private int proposedChallenge;
	
	 @OneToMany (mappedBy = "watcher")
	 @JsonBackReference
	 private List<Challenge> challenge;
	 
	 
	 
	 
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


	public List<Challenge> getChallenge() {
		return challenge;
	}


	public void setChallenge(List<Challenge> challenge) {
		this.challenge = challenge;
	}
	 
	 
}
