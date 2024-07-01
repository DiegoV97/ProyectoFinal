package com.proyectoback.proyectoBack.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.proyectoback.proyectoBack.entitys.Watcher;

public interface WatcherRepository extends CrudRepository<Watcher, Integer>{
	
	@Query("SELECT u FROM User u WHERE u.username=:username")
	   Watcher findByUsername(@Param("username")String username);
}
