package com.proyectoback.proyectoBack.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.proyectoback.proyectoBack.entitys.Video;


public interface VideoRepository extends CrudRepository<Video, Integer>{

	@Query("SELECT v FROM Video v WHERE v.id=:id")
	   Video findById(@Param("id")int id);

	@Query("SELECT v FROM Video v WHERE v.player.id=:playerId ORDER BY v.id DESC")
	List<Video> findAllByPlayerIdOrderByIdDesc(@Param("playerId") int playerId);

}
