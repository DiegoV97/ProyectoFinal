package com.proyectoback.proyectoBack.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.proyectoback.proyectoBack.entitys.Challenge;

public interface ChallengeRepository extends CrudRepository<Challenge, Integer>{
	
	@Query(value = "SELECT * FROM challenge ORDER BY created_date DESC", nativeQuery = true)
	List<Challenge> findAllByOrderByCreatedDateDesc();

}

