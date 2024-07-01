package com.proyectoback.proyectoBack.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.proyectoback.proyectoBack.entitys.Player;


public interface PlayerRepository extends CrudRepository<Player, Integer>  {

	@Query("SELECT u FROM User u WHERE u.username=:username")
	   Player findByUsername(@Param("username")String username);
	
}
