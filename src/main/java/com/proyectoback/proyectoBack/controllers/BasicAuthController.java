package com.proyectoback.proyectoBack.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicAuthController {
	
	@PostMapping("/login")
	public String basicauth(Principal principal) {
		return principal.getName();
	}

}
