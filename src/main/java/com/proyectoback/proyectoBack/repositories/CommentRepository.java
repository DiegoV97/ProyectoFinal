package com.proyectoback.proyectoBack.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyectoback.proyectoBack.entitys.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
	
	
}
