package com.proyectoback.proyectoBack.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private RepositorioUsuario usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    Usuario user = usuarioRepository.findByUserName(username);
	    if (null == user) {
	        throw new UsernameNotFoundException("Usuario no encontrado: " + username);
	    }   
	    return user;
	}

}
