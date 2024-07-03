package com.proyectoback.proyectoBack.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoback.proyectoBack.entitys.Player;
import com.proyectoback.proyectoBack.entitys.User;
import com.proyectoback.proyectoBack.entitys.Watcher;
import com.proyectoback.proyectoBack.repositories.UserRepository;

@RestController
public class BasicAuthController {
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/login")
	public ResponseEntity<String> basicauth(Principal principal) {
		 User user = userRepository.findByUsername(principal.getName());
		 
		 if (user instanceof Watcher == true) {
			return ResponseEntity.ok().body("{\"rol\":\"watcher\"}");
		} else if (user instanceof Player == true) {
			return ResponseEntity.ok().body("{\"rol\":\"player\"}");
		}
		return null;
	}

}
