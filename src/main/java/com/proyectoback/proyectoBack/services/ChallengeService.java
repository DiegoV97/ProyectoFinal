package com.proyectoback.proyectoBack.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyectoback.proyectoBack.entitys.Challenge;
import com.proyectoback.proyectoBack.repositories.ChallengeRepository;

public class ChallengeService {

	@Autowired
    private ChallengeRepository challengeRepository;

    public List<Challenge> getAllChallengesOrderedByDate() {
        return challengeRepository.findAllByOrderByCreatedDateDesc();
    }
}
