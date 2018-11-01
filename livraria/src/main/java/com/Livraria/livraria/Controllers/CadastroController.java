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
import com.Livraria.livraria.model.Cadastro;
import com.Livraria.livraria.repository.CadastroRepository;



@RestController
public class CadastroController {

	@Autowired
	private CadastroRepository cadastroRepository;
	
	@GetMapping("/Cadastro")
	public Page<Cadastro> getCadastro(Pageable pageable){
		return cadastroRepository.findAll(pageable);
	}
	
	@PostMapping("/Cadastro")
	public Cadastro createCadastro(@Valid @RequestBody Cadastro cadastro) {
		return cadastroRepository.save(cadastro);
	}
	
	@PutMapping("/cadastro/{cadastroId}")
	public Cadastro updateCadastro(@PathVariable Long cadastroId,
            								@Valid @RequestBody Cadastro cadastroRequest) {
		return  cadastroRepository.findById(cadastroId)
				.map(cadastro-> {
			
					cadastro.setNomeCompleto(cadastroRequest.getNomeCompleto());
					cadastro.setSenha(cadastroRequest.getSenha());
					cadastro.setEmail(cadastroRequest.getEmail());
					cadastro.setIdade(cadastroRequest.getIdade());
					return cadastroRepository.save(cadastro);
		}).orElseThrow(() -> new ResourceNotFoundException("CADASTRO CONCLUIDO: " + cadastroId));
	}
	
	@DeleteMapping("/Cadastro/{CadastroId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Long cadastroId) throws RelationNotFoundException{
		return cadastroRepository.findById(cadastroId)
			.map(cadastro -> {
					cadastroRepository.delete(cadastro);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new RelationNotFoundException("CADASTRO NÃO CONCLUIDO: " + cadastroId));
	}
}
