package com.proyectoback.proyectoBack.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoback.proyectoBack.entitys.Challenge;
import com.proyectoback.proyectoBack.repositories.ChallengeRepository;

@Service
public class ChallengeService {

	@Autowired
    private ChallengeRepository challengeRepository;

    public List<Challenge> getAllChallengesOrderedByDate() {
        return challengeRepository.findAllByOrderByCreatedDateDesc();
    }
}
