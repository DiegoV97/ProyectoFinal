package com.proyectoback.proyectoBack.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.proyectoback.proyectoBack.Dto.UserDto;
import com.proyectoback.proyectoBack.entitys.Moderator;
import com.proyectoback.proyectoBack.entitys.Player;
import com.proyectoback.proyectoBack.entitys.User;
import com.proyectoback.proyectoBack.entitys.Watcher;
import com.proyectoback.proyectoBack.repositories.ModeratorRepository;
import com.proyectoback.proyectoBack.repositories.PlayerRepository;
import com.proyectoback.proyectoBack.repositories.UserRepository;
import com.proyectoback.proyectoBack.repositories.WatcherRepository;
import com.proyectoback.proyectoBack.services.CloudinaryService;

@CrossOrigin
@RestController
@RequestMapping(path = "/user")
public class UserController {
	//final Path root = Paths.get("uploads");
	
//	  @Value("${upload.dir}")
//	    private String uploadDir;

	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private WatcherRepository watcherRepository;
	@Autowired
	private ModeratorRepository moderatorRepository;
	 @Autowired
	 private CloudinaryService cloudinaryService;

	@Autowired
	BCryptPasswordEncoder encoder;

	@PostMapping("/register")
	public void createUser(@RequestBody UserDto user) {
		user.setPassword(encoder.encode(user.getPassword()));

		if (user.getRol().equals("player")) {
			Player n = new Player(user);
			playerRepository.save(n);

		} else if (user.getRol().equals("watcher")) {
			Watcher w = new Watcher(user);
			watcherRepository.save(w);
			
		} else if (user.getRol().equals("moderador")) {
			Moderator m = new Moderator(user);
			moderatorRepository.save(m);
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
	public void updatePeople(@RequestBody User user, @PathVariable("id") Integer id) {
		user.setId(id);
		userRepository.save(user);
	}

	@GetMapping("/{username}")
	public User selectUserById(@PathVariable("username")String username) {
		return userRepository.findByUsername(username);
	}
	
	@GetMapping("/ranking")
	public List<User> orderByPoints(){
		List<User> points = userRepository.orderByPoints();
		return points;
	}

	//@PostMapping("/upload")
	//public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {
		//try {
		  //    Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
			//	return ResponseEntity.ok().body("{\"resp\":\"Archivo cargado con éxito\"}");
  
		 //} catch (Exception e) {
		   //   if (e instanceof FileAlreadyExistsException) {
		     //   throw new RuntimeException("A file of that name already exists.");
		      //}
		      //throw new RuntimeException(e.getMessage());
		    //}
	//}
	
	@PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("username") String username) {
        if (file.isEmpty()) {
            return "Archivo vacío";
        }

        User user = userRepository.findByUsername(username);
        if (user == null) {
            return "Usuario no encontrado";
        }

        try {
            // Generar un nombre de archivo único
//            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
//            Path path = Paths.get(uploadDir + File.separator + fileName);
//            Files.copy(file.getInputStream(), path);
        	
        	Map result = cloudinaryService.upload(file);

        	user.setImagenUrl((String)result.get("url"));     
            userRepository.save(user);

            return "Archivo subido exitosamente: " + user.getImagenUrl();
        } catch (IOException e) {
            e.printStackTrace();
            return "Fallo al subir el archivo";
        }
    }
}
