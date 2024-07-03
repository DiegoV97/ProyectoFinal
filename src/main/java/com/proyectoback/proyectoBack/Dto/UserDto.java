package com.proyectoback.proyectoBack.Dto;

import com.proyectoback.proyectoBack.entitys.User;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDto extends User {
	
	private String rol;
	
}
