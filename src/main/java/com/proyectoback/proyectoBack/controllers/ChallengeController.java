package com.proyectoback.proyectoBack.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.proyectoback.proyectoBack.entitys.Challenge;
import com.proyectoback.proyectoBack.entitys.Player;
import com.proyectoback.proyectoBack.entitys.Watcher;
import com.proyectoback.proyectoBack.repositories.ChallengeRepository;
import com.proyectoback.proyectoBack.repositories.PlayerRepository;
import com.proyectoback.proyectoBack.repositories.WatcherRepository;
import com.proyectoback.proyectoBack.services.CloudinaryService;


@RestController
@RequestMapping("/challenge")
public class ChallengeController {
    
	@Autowired
    private ChallengeRepository challengeRepository;
	
	@Autowired WatcherRepository watcherRepository;
	
	@Autowired PlayerRepository playerRepository;
	
	@Autowired CloudinaryService cloudinaryService;

    @GetMapping
    public List<Challenge> getAllChallenge() {
        return challengeRepository.findAll();
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
    public Challenge createChallenge(@RequestParam("description") String description, @RequestParam("points") int points, @RequestParam("watcher") int id_watcher) {
    	Watcher watcher = watcherRepository.findById(id_watcher)
    	        .orElseThrow(() -> new RuntimeException("Watcher not found"));
    	Challenge challenge = new Challenge();
    	challenge.setDescription(description);
    	challenge.setPoints(points);
    	challenge.setWatcher(watcher);
        return challengeRepository.save(challenge);
    }

    @PutMapping("/{id}")
    public Challenge updateChallenge(@PathVariable int id,@RequestParam("player") int id_player ) {
    	
        Challenge challenge = challengeRepository.findById(id).orElse(null);
       
    		
    		Player player = playerRepository.findById(id_player)
        	        .orElseThrow(() -> new RuntimeException("Player not found"));
    		
    	 	
        	challenge.setPlayer(player);
    		return challengeRepository.save(challenge);
     
    }

    @DeleteMapping("/{id}")
    public void deleteChallenge(@PathVariable int id) {
        challengeRepository.deleteById(id);
    }
    
	@PostMapping("/{id}/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("id") int id) {
        if (file.isEmpty()) {
            return "Archivo vacío";
        }

        Challenge challenge = challengeRepository.findById(id).get();
        if (challenge == null) {
            return "Challenge no encontrado";
        }

        try {
            // Generar un nombre de archivo único
//            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
//            Path path = Paths.get(uploadDir + File.separator + fileName);
//            Files.copy(file.getInputStream(), path);
        	
        	Map result = cloudinaryService.uploadVideo(file);

        	challenge.setVideoUrl((String)result.get("url"));     
            challengeRepository.save(challenge);

            return "Archivo subido exitosamente: " + challenge.getVideoUrl();
        } catch (IOException e) {
            e.printStackTrace();
            return "Fallo al subir el archivo";
        }
    }
}

