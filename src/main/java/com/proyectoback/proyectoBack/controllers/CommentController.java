package com.proyectoback.proyectoBack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoback.proyectoBack.entitys.Comment;
import com.proyectoback.proyectoBack.entitys.Player;
import com.proyectoback.proyectoBack.entitys.User;
import com.proyectoback.proyectoBack.entitys.Video;
import com.proyectoback.proyectoBack.repositories.CommentRepository;
import com.proyectoback.proyectoBack.repositories.UserRepository;
import com.proyectoback.proyectoBack.repositories.VideoRepository;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	 @Autowired
	 private CommentRepository commentRepository;
	 
	 @Autowired 
	 private VideoRepository videoRepository;
	 
	 @Autowired
	 private UserRepository userRepository;
	 
	 @PostMapping
	 public String createComment(@RequestParam("content") String content, @RequestParam("user") String username, @RequestParam("video") int 		videoId) {
		 
		 	User user = userRepository.findByUsername(username);
	        if (user == null) {
	            return "Usuario no encontrado";
	        }
	        
	        Video video = videoRepository.findById(videoId);
	        if (video == null) {
	            return "Usuario no encontrado";
	        }
	        
		 Comment comment = new Comment();
		 
		 comment.setContent(content);
		 comment.setUser(user);
		 comment.setVideo(video);
		 commentRepository.save(comment);
		 
	     return "Comentario creado";
	     
	    }

}
