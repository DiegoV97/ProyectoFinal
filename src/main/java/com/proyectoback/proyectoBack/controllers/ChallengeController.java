package com.proyectoback.proyectoBack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoback.proyectoBack.entitys.Challenge;
import com.proyectoback.proyectoBack.entitys.User;
import com.proyectoback.proyectoBack.repositories.ChallengeRepository;


@RestController
@RequestMapping("/challenge")
public class ChallengeController {
    
	@Autowired
    private ChallengeRepository challengeRepository;

    @GetMapping
    public List<Challenge> getAllChallenge() {
        return challengeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Challenge getChallengeById(@PathVariable int id) {
        return challengeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Challenge createChallenge(@RequestBody Challenge challenge) {
        return challengeRepository.save(challenge);
    }

    @PutMapping("/{id}")
    public Challenge updateChallenge(@PathVariable int id, @RequestBody Challenge challengeDetails) {
        Challenge challenge = challengeRepository.findById(id).orElse(null);
        if (challenge != null) {
            challenge.setDescription(challengeDetails.getDescription());
            challenge.setPoints(challengeDetails.getPoints());
            challenge.setWatcher(challengeDetails.getWatcher());
            challenge.setPlayer(challengeDetails.getPlayer());
            return challengeRepository.save(challenge);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteChallenge(@PathVariable int id) {
        challengeRepository.deleteById(id);
    }
}

