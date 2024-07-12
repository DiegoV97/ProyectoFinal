package com.proyectoback.proyectoBack.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoback.proyectoBack.entitys.User;
import com.proyectoback.proyectoBack.entitys.Video;
import com.proyectoback.proyectoBack.repositories.UserRepository;
import com.proyectoback.proyectoBack.repositories.VideoRepository;


@RestController
	@RequestMapping("/videos")
	public class VideoController {
	 
	}



