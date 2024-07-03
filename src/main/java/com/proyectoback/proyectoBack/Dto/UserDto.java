package com.proyectoback.proyectoBack.Dto;

import com.proyectoback.proyectoBack.entitys.User;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Data
public class UserDto extends User {
	
	private String rol;

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	

}
