package com.proyectoback.proyectoBack.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.proyectoback.proyectoBack.entitys.User;

@Repository

public interface UserRepository extends CrudRepository<User, Integer> {
	List <User> findAll();

	  @Query("SELECT u FROM User u WHERE u.username=:username")
	   User findByUsername(@Param("username")String username);
	  
	  @Query("SELECT u FROM Player u ORDER BY u.points DESC")
	  	List<User> orderByPoints();
	  
	  
}