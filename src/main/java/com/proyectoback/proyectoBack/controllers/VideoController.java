package com.proyectoback.proyectoBack.controllers;


import java.util.Optional;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyectoback.proyectoBack.entitys.Video;
import com.proyectoback.proyectoBack.repositories.VideoRepository;


@RestController
	@RequestMapping("/videos")
	public class VideoController {
	    @Autowired
	    private VideoRepository videoRepository;

	    @PostMapping("/{id}/like")
	    public ResponseEntity<String> likeVideo(@PathVariable Integer id) {
	        Optional<Video> optionalVideo = videoRepository.findById(id);
	        if (optionalVideo.isPresent()) {
	            Video video = optionalVideo.get();
	            video.setLikes(video.getLikes() + 1);
	            videoRepository.save(video);
	            return ResponseEntity.ok("Me gusta añadido.");
	        } else {
	            return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body("Video no encontrado.");
	        }
	    }
	}



