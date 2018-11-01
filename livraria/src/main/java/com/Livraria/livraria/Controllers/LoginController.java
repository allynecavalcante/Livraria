package com.Livraria.livraria.Controllers;


import javax.management.relation.RelationNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Livraria.livraria.Exception.ResourceNotFoundException;
import com.Livraria.livraria.model.Login;
import com.Livraria.livraria.repository.LoginRepository;



@RestController
public class LoginController {

	@Autowired
	private LoginRepository LoginRepository;
	
	@GetMapping("/Login")
	public Page<Login> getLogin(Pageable pageable){
		return LoginRepository.findAll(pageable);
	}
	
	@PostMapping("/login")
	public Login createLogin(@Valid @RequestBody Login login) {
		return LoginRepository.save(login);
	}
	
	@PutMapping("/login/{loginId}")
	public Login updateLogin(@PathVariable Long loginId,
            								@Valid @RequestBody Login loginRequest) {
		return LoginRepository.findById(loginId)
				.map(login-> {
			
					login.setSenha(loginRequest.getSenha());
					login.setEmail(loginRequest.getEmail());
					return LoginRepository.save(login);
		}).orElseThrow(() -> new ResourceNotFoundException("LOGIN CONCLUIDO: " + loginId));
	}
	
	@DeleteMapping("/Login/{LoginId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Long loginId) throws RelationNotFoundException{
		return LoginRepository.findById(loginId)
			.map(login -> {
					LoginRepository.delete(login);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new RelationNotFoundException("LOGIN NÃO CONCLUIDO: " + loginId));
	}
}
