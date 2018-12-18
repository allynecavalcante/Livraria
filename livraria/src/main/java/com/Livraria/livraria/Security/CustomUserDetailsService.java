package com.Livraria.livraria.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.Livraria.livraria.repository.LoginRepository;


@Component
public class CustomUserDetailsService implements UserDetailsService {

	 private LoginRepository users;

	    public CustomUserDetailsService(LoginRepository users) {
	        this.users = users;
	    }

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        return this.users.findByEmail(username)
	            .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));
	    }
}
