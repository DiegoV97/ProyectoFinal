package com.proyectoback.proyectoBack.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyectoback.proyectoBack.entitys.Challenge;

public interface ChallengeRepository extends CrudRepository<Challenge, Integer>{
	

	List<Challenge> findAll();
	
	@Query(value = "SELECT  * FROM challenge ORDER BY id DESC", nativeQuery = true)
	List<Challenge> findAllByOrderByDesc();


}

