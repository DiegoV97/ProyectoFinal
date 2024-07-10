package com.proyectoback.proyectoBack.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;
<<<<<<< HEAD

import org.springframework.beans.factory.annotation.Autowired;
=======
import java.util.Optional;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
>>>>>>> 0ed99e71df9ff8158330b7bc5a81d31c816dbe97
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.proyectoback.proyectoBack.entitys.Challenge;
import com.proyectoback.proyectoBack.entitys.Player;
<<<<<<< HEAD
import com.proyectoback.proyectoBack.entitys.Watcher;
import com.proyectoback.proyectoBack.repositories.ChallengeRepository;
import com.proyectoback.proyectoBack.repositories.PlayerRepository;
import com.proyectoback.proyectoBack.repositories.WatcherRepository;
import com.proyectoback.proyectoBack.services.CloudinaryService;
import com.proyectoback.proyectoBack.services.ChallengeService;
=======
import com.proyectoback.proyectoBack.entitys.Video;
import com.proyectoback.proyectoBack.entitys.Watcher;
import com.proyectoback.proyectoBack.repositories.ChallengeRepository;
import com.proyectoback.proyectoBack.repositories.PlayerRepository;
import com.proyectoback.proyectoBack.repositories.VideoRepository;
import com.proyectoback.proyectoBack.repositories.WatcherRepository;
import com.proyectoback.proyectoBack.services.CloudinaryService;
>>>>>>> 0ed99e71df9ff8158330b7bc5a81d31c816dbe97


@RestController
@RequestMapping("/challenge")
public class ChallengeController {
    
	@Autowired
<<<<<<< HEAD
    private ChallengeService challengeService;
	
	@Autowired
=======
>>>>>>> 0ed99e71df9ff8158330b7bc5a81d31c816dbe97
    private ChallengeRepository challengeRepository;
	
	@Autowired WatcherRepository watcherRepository;
	
	@Autowired PlayerRepository playerRepository;
	
	@Autowired CloudinaryService cloudinaryService;
<<<<<<< HEAD

    @GetMapping
    public List<Challenge> getHomeChallenges() {
        return challengeService.getAllChallengesOrderedByDate();
=======
	
	@Autowired VideoRepository videoRepository;

    @GetMapping
    public List<Challenge> getAllChallenge() {
        return challengeRepository.findAll();
>>>>>>> 0ed99e71df9ff8158330b7bc5a81d31c816dbe97
    }

    @GetMapping("/{id}")
    public Challenge getChallengeById(@PathVariable int id) {
        return challengeRepository.findById(id).orElse(null);
    }

//    @PostMapping
//    public Challenge createChallenge(@RequestBody Challenge challenge) {
//    	Watcher watcher = watcherRepository.findById(challenge.getWatcher().getId())
//    	        .orElseThrow(() -> new RuntimeException("Watcher not found"));
//    	challenge.setWatcher(watcher);
//        return challengeRepository.save(challenge);
//    }
    
    @PostMapping
    public Challenge createChallenge(@RequestParam("description") String description, @RequestParam("points") int points, @RequestParam("watcher") String username_watcher) {
<<<<<<< HEAD
    	Watcher watcher = watcherRepository.findByUsername(username_watcher); 
=======
    	Watcher watcher = watcherRepository.findByUsername(username_watcher);
    	        
>>>>>>> 0ed99e71df9ff8158330b7bc5a81d31c816dbe97
    	Challenge challenge = new Challenge();
    	challenge.setDescription(description);
    	challenge.setPoints(points);
    	challenge.setWatcher(watcher);
<<<<<<< HEAD
    	
    	return challengeRepository.save(challenge);
          
=======
        return challengeRepository.save(challenge);
>>>>>>> 0ed99e71df9ff8158330b7bc5a81d31c816dbe97
    }

    @PutMapping("/{id}")
    public Challenge updateChallenge(@PathVariable int id,@RequestBody Map<String, String> requestBody ) {
    	
    		String username = requestBody.get("username");
        Challenge challenge = challengeRepository.findById(id).orElse(null);
       
    		System.out.println(username);
    		Player player = playerRepository.findByUsername(username);
    	 	
        	challenge.setPlayer(player);
    		return challengeRepository.save(challenge);
     
    }

    @DeleteMapping("/{id}")
    public void deleteChallenge(@PathVariable int id) {
        challengeRepository.deleteById(id);
    }
    

<<<<<<< HEAD
	@PostMapping("/{id}/upload")

    public String uploadFile(@PathVariable int id,@RequestParam("player") String username,@RequestParam("watcher")String usernamewatcher, @RequestParam("file") MultipartFile file, @RequestParam("points") int points) {
=======
	@PostMapping("/upload")

    public String uploadFile(@RequestParam("player") String username,@RequestParam("watcher")String usernamewatcher, @RequestParam("file") MultipartFile file, @RequestParam("points") int points, @RequestParam("challenge") int idchallenge ) {
>>>>>>> 0ed99e71df9ff8158330b7bc5a81d31c816dbe97
        if (file.isEmpty()) {
            return "Archivo vacío";
        }

<<<<<<< HEAD
        Challenge challenge = challengeRepository.findById(id).get();
=======
        Challenge challenge = challengeRepository.findById(idchallenge).get();
>>>>>>> 0ed99e71df9ff8158330b7bc5a81d31c816dbe97
        if (challenge == null) {
            return "Challenge no encontrado";
        }
        Player player = playerRepository.findByUsername(username);
        if (player == null) {
            return "Player no encontrado";
        }
        Watcher watcher = watcherRepository.findByUsername(usernamewatcher);
        if ( watcher == null) {
        	return "Watcher no encontrado";
        }
<<<<<<< HEAD
=======
        Video video = new Video();
        
>>>>>>> 0ed99e71df9ff8158330b7bc5a81d31c816dbe97

        try {
            // Generar un nombre de archivo único
//            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
//            Path path = Paths.get(uploadDir + File.separator + fileName);
//            Files.copy(file.getInputStream(), path);
        	
        	Map result = cloudinaryService.uploadVideo(file);

        	player.setPoints(points);
        	player.setChallengeCompleted(1);
        	watcher.setProposedChallenge(1);
<<<<<<< HEAD
        	
        	challenge.setVideoUrl((String)result.get("url"));     
            challengeRepository.save(challenge);
            

            return "Archivo subido exitosamente: " + challenge.getVideoUrl();
=======
        	video.setPlayer(player);
        	video.setVideoUrl((String)result.get("url"));
        	video.setChallenge(challenge);
            videoRepository.save(video);
            

            return "Archivo subido exitosamente: " + video.getVideoUrl();
>>>>>>> 0ed99e71df9ff8158330b7bc5a81d31c816dbe97
        } catch (IOException e) {
            e.printStackTrace();
            return "Fallo al subir el archivo";
        }
    }
<<<<<<< HEAD
}

=======
	 
}


>>>>>>> 0ed99e71df9ff8158330b7bc5a81d31c816dbe97
