package com.proyectoback.proyectoBack.entitys;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.proyectoback.proyectoBack.Dto.UserDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity

public class Player extends User {

    private int challengeCompleted;
    private int points;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Challenge> challenges;

    public Player(UserDto user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public Player() {
        super();
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points + this.points;
    }

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }

    public int getChallengeCompleted() {
        return challengeCompleted;
    }

    public void setChallengeCompleted(int challengeCompleted) {
        this.challengeCompleted = challengeCompleted + this.challengeCompleted;
    }
}

