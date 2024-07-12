package com.proyectoback.proyectoBack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoback.proyectoBack.entitys.MeGusta;
import com.proyectoback.proyectoBack.entitys.User;
import com.proyectoback.proyectoBack.entitys.Video;
import com.proyectoback.proyectoBack.repositories.MeGustaRepository;
import com.proyectoback.proyectoBack.repositories.UserRepository;
import com.proyectoback.proyectoBack.repositories.VideoRepository;
@RestController
@RequestMapping("/like")
public class MeGustaController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
    private VideoRepository videoRepository;
	@Autowired
	private MeGustaRepository meGustaRepository;
	
	
	 @PostMapping
	    public String createLike( @RequestParam("user") String username, @RequestParam("video") int id) {
		 
		 User user = userRepository.findByUsername(username);
		 Video video = videoRepository.findById(id);
		 MeGusta meGusta=meGustaRepository.consultaMeGusta(user.getId(), video.getId());
		 
		 
		 if(meGusta != null) {
			 meGustaRepository.deleteById(meGusta.getId());
			 return "Me gusta borrado";
			 
		 }else
		 {  MeGusta meGusta2 = new MeGusta();
		 	meGusta2.setUser(user);
		 	meGusta2.setVideo(video);	 
		  meGustaRepository.save(meGusta2);
		 return "Me gusta creado";
	    }
	 }
	 

}
