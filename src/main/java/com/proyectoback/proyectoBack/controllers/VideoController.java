package com.proyectoback.proyectoBack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyectoback.proyectoBack.entitys.Video;
import com.proyectoback.proyectoBack.repositories.VideoRepository;

@RestController
	@RequestMapping("/videos")

	public class VideoController {
		
		@Autowired
		VideoRepository videoRepository;
		
		  @GetMapping("/{id}")
		    public Video getVideoById(@PathVariable int id) {
		    	
		    Video video = videoRepository.findById(id);
		    
		        return video;
		    }
	}



