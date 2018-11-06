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
import com.Livraria.livraria.model.Livro;
import com.Livraria.livraria.repository.LivroRepository;



@RestController
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping("/Livro")
	public Page<Livro> getLivro(Pageable pageable){
		return livroRepository.findAll(pageable);
	}
	
	@GetMapping("/livro/{livroId}")
	public Livro getlivro (@PathVariable Long livroId) {
		return livroRepository.findById(livroId)
				.orElseThrow(() -> new ResourceNotFoundException("LIVRO: " + livroId));
		
			}
	
	@PostMapping("/Livro")
	public Livro createLivro(@Valid @RequestBody Livro livro) {
		return livroRepository.save(livro);
	}
	
	@PutMapping("/livro/{livroId}")
	public Livro updateLivro(@PathVariable Long livroId,
            								@Valid @RequestBody Livro livroRequest) {
		return  livroRepository.findById(livroId)
				.map(livro-> {
			
					livro.setNomedoLivro(livroRequest.getNomedoLivro());
					livro.setQnt(livroRequest.getQnt());
					livro.setCodigoLivro(livroRequest.getCodigoLivro());
					livro.setTipo(livroRequest.getTipo());
					livro.setAutor(livroRequest.getAutor());
					livro.setDescrição(livroRequest.getDescrição());
					return livroRepository.save(livro);
		}).orElseThrow(() -> new ResourceNotFoundException("LIVRO CADASTRADO: " + livroId));
	}
	
	@DeleteMapping("/livro/{livroId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Long livroId) throws RelationNotFoundException{
		return livroRepository.findById(livroId)
			.map(livro -> {
					livroRepository.delete(livro);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new RelationNotFoundException("LIVRO NÃO CADASTRADO: " + livroId));
	}

}
