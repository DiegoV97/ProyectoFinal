package com.proyectoback.proyectoBack.entitys;

import java.util.ArrayList;


import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter @Setter

public class User implements UserDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	@Column(unique = true, nullable = false)
	protected String username;
	@Column(unique = true, nullable = false)
	protected String email;
	protected String password;
	private boolean accountNonExpired = true;
	private boolean accountNonLocked= true;
	private boolean credentialsNonExpired = true;
	private boolean enabled= true;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// Devolvemos un ArrayList vacío porque nuestra app no tiene roles
		return new ArrayList<>();
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}
	

}
