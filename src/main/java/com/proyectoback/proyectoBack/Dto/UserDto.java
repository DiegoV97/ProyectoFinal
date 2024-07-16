package com.proyectoback.proyectoBack.Dto;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter 
public class UserDto {
	
	private String rol;
	private String username;
	private String password;
	private String email;
	private int points;
}
