package com.proyectoback.proyectoBack.repositories;

import java.util.List;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
=======

import org.springframework.data.repository.CrudRepository;

>>>>>>> 0ed99e71df9ff8158330b7bc5a81d31c816dbe97
import com.proyectoback.proyectoBack.entitys.Challenge;

public interface ChallengeRepository extends CrudRepository<Challenge, Integer>{
	
<<<<<<< HEAD
	@Query(value = "SELECT * FROM challenge ORDER BY id DESC", nativeQuery = true)
	List<Challenge> findAllByOrderByCreatedDateDesc();
=======
	List<Challenge> findAll();
>>>>>>> 0ed99e71df9ff8158330b7bc5a81d31c816dbe97

}

