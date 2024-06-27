package com.proyectoback.proyectoBack.repositories;

import org.springframework.data.repository.CrudRepository;

import com.proyectoback.proyectoBack.Dto.UserDto;
import com.proyectoback.proyectoBack.entitys.Player;

public interface PlayerRepository extends CrudRepository<Player, Integer>  {

	
	
}
