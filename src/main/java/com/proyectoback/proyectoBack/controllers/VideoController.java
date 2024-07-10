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
	    @Autowired
	    private VideoRepository videoRepository;
	    @Autowired
		private UserRepository userRepository;
	    
	    
	 

	    @PostMapping("/{id}/like")
	    public ResponseEntity<String> likeVideo(@PathVariable Integer id) {
	        Optional<Video> optionalVideo = videoRepository.findById(id);
	        if (optionalVideo.isPresent()) {
	            Video video = optionalVideo.get();
	            video.setLikes(video.getLikes());
	            videoRepository.save(video);
	            return ResponseEntity.ok("Me gusta añadido.");
	        } else {
	            return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body("Video no encontrado.");
	        }
	    }
	    
	    @PutMapping("/userlikes/{id}")
	    public ResponseEntity<String> userLikesVideo(@PathVariable Integer id, @RequestParam("user") String username) {
	        Optional<Video> optionalVideo = videoRepository.findById(id);
	        System.out.println("**************"+id);
	        if (optionalVideo.isPresent()) {
	            Video video = optionalVideo.get();
	            User user = userRepository.findByUsername(username);
	            List <User> likes= video.getLikes();
	            if(likes == null) {
	            	likes = new ArrayList<User>();
	            }
	            likes.add(user);
	            video.setLikes(likes);
	            if (user != null) {
	                //video.getLikes().add(user);
	                videoRepository.save(video);
	                return ResponseEntity.ok("Usuario añadió like al video.");
	            } else {
	                return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body("Usuario no encontrado.");
	            }
	        } else {
	            return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body("Video no encontrado.");
	        }
	    }
	}



