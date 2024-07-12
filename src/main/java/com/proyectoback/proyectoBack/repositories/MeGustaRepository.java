package com.proyectoback.proyectoBack.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.proyectoback.proyectoBack.entitys.MeGusta;

public interface MeGustaRepository extends CrudRepository<MeGusta, Integer> {
	
	@Query ("SELECT m FROM MeGusta m WHERE m.user.id=:userId and m.video.id=:videoId ")
	   MeGusta consultaMeGusta(@Param("userId")int userId, @Param("videoId") int videoId);

}
