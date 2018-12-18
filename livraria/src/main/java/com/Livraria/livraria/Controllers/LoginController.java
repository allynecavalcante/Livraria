package com.Livraria.livraria.Controllers;


import java.util.HashMap;
import java.util.Map;

import javax.management.relation.RelationNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Livraria.livraria.Exception.ResourceNotFoundException;
import com.Livraria.livraria.Security.JwtTokenProvider;
import com.Livraria.livraria.model.Login;
import com.Livraria.livraria.repository.LoginRepository;

import static org.springframework.http.ResponseEntity.ok;



@RestController
public class LoginController {
	

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    LoginRepository users;
    

	@Autowired
	private LoginRepository loginRepository;
	
	@GetMapping("/login")
	public Page<Login> getLogin(Pageable pageable){
		return loginRepository.findAll(pageable);
	}
	
	@PostMapping("/login")
	public Login createLogin(@Valid @RequestBody Login login) {
		return loginRepository.save(login);
	}
	
	@PutMapping("/login/{loginId}")
	public Login updateLogin(@PathVariable Long loginId,
            								@Valid @RequestBody Login loginRequest) {
		return loginRepository.findById(loginId)
				.map(login-> {
			
					login.setSenha(loginRequest.getSenha());
					login.setEmail(loginRequest.getEmail());
					return loginRepository.save(login);
		}).orElseThrow(() -> new ResourceNotFoundException("LOGIN CONCLUIDO: " + loginId));
	}
	
	@DeleteMapping("/login/{LoginId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Long loginId) throws RelationNotFoundException{
		return loginRepository.findById(loginId)
			.map(login -> {
					loginRepository.delete(login);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new RelationNotFoundException("LOGIN NÃO CONCLUIDO: " + loginId));
	}
	
	@PostMapping("/logar")
	public ResponseEntity login (@RequestBody Map<String, String> params) {
		try {
            String username = params.get("email");
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, params.get("senha")));
            String token = jwtTokenProvider.createToken(username, this.users.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found")).getRoles());

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }


		
	}

	
 