package com.proyectoback.proyectoBack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoback.proyectoBack.Dto.UserDto;
import com.proyectoback.proyectoBack.entitys.Player;
import com.proyectoback.proyectoBack.entitys.User;
import com.proyectoback.proyectoBack.entitys.Watcher;
import com.proyectoback.proyectoBack.repositories.PlayerRepository;
import com.proyectoback.proyectoBack.repositories.UserRepository;
import com.proyectoback.proyectoBack.repositories.WatcherRepository;


@CrossOrigin
@RestController
@RequestMapping(path = "/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private WatcherRepository watcherRepository;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@PostMapping("/register")
	public void createUser(@RequestBody UserDto user) {
	    user.setPassword(encoder.encode(user.getPassword()));
	    
	    if( user.getRol()== 0) { 
	    	Player n = new Player(user);		
	    	playerRepository.save(n);
	    	
	    } else if ( user.getRol()==1) {
	    	Watcher w = new Watcher(user);
	    			watcherRepository.save(w);
	    }
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		User i = new User();
		i.setId(id);
		userRepository.delete(i);
	}
	
	@GetMapping
	public List<User> selectPeople() {
		List<User> people = userRepository.findAll();
		return people;
	}
	
	@PutMapping("/{id}")
	public void updatePeople(@RequestBody User user, @PathVariable("id")Integer id) {
		user.setId(id);
		userRepository.save(user);
	}
	
	@GetMapping("/{id}")
	public User selectUserById(@PathVariable("id")Integer id) {
		return userRepository.findById(id).orElse(null);
	}
	

}
