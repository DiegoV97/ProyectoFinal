package com.proyectoback.proyectoBack;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ChallengeRepository extends CrudRepository<Challenge, Integer>{
	
	List<Challenge> findAll();

}

