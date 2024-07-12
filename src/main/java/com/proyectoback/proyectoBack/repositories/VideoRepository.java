package com.proyectoback.proyectoBack.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.proyectoback.proyectoBack.entitys.Video;

public interface VideoRepository extends CrudRepository<Video, Integer>{

	@Query("SELECT v FROM Video v WHERE v.id=:id")
	   Video findById(@Param("id")int id);

}
