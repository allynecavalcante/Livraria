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
import com.Livraria.livraria.model.Administrador;
import com.Livraria.livraria.repository.AdmRepository;




@RestController
public class AdmController {
	@Autowired
	private AdmRepository admRepository;
	
	@GetMapping("/Administrador")
	public Page<Administrador> getAdministrador(Pageable pageable){
		return admRepository.findAll(pageable);
	}
	
	@PostMapping("/Administrador")
	public Administrador createAdministrador(@Valid @RequestBody Administrador administrador) {
		return admRepository.save(administrador);
	}
	
	@PutMapping("/administrador/{administradorId}")
	public Administrador updateAdministrador(@PathVariable Long administradorId,
            								@Valid @RequestBody Administrador administradorRequest) {
		return  admRepository.findById(administradorId)
				.map( administrador-> {
			
					administrador.setCadastroLivro(administradorRequest.getCadastroLivro());
					administrador.setRemoverLivro(administradorRequest.getRemoverLivro());
					administrador.setAdiconarComentarios(administradorRequest.getAdiconarComentarios());
					return admRepository.save(administrador);
		}).orElseThrow(() -> new ResourceNotFoundException("REMOÇÃO CONCLUIDA: " + administradorId));
	}
	
	@DeleteMapping("/Administrador/{administradorId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Long administradorId) throws RelationNotFoundException{
		return admRepository.findById(administradorId)
			.map(administrador -> {
				admRepository.delete(administrador);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new RelationNotFoundException("REMOÇÃO NÃO CONCLUIDO: " + administradorId));
	}

}
