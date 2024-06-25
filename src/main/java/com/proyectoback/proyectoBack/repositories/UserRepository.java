package com.proyectoback.proyectoBack.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.proyectoback.proyectoBack.entitys.User;

@Repository

public interface UserRepository extends CrudRepository<User, Integer> {
	List <User> findAll();

}
