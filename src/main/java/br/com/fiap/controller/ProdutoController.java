package br.com.fiap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fiap.entity.ProdutoEntity;
import br.com.fiap.service.interfaces.IProdutoService;

@RestController
@RequestMapping("Cadastro")
public class ProdutoController {

	@Autowired
	private IProdutoService service;

	@RequestMapping("TesteProduto")
	public String greeting() {
		return "Teste!";
	}

	@GetMapping("produto/{identificador}")
	public ResponseEntity<ProdutoEntity> getById(@PathVariable("identificador") Integer identificador) {
		ProdutoEntity entity = service.getById(identificador);
		return new ResponseEntity<ProdutoEntity>(entity, HttpStatus.OK);
	}

	@GetMapping("produtos")
	public ResponseEntity<List<ProdutoEntity>> getAll() {
		List<ProdutoEntity> lista = service.getAll();
		return new ResponseEntity<List<ProdutoEntity>>(lista, HttpStatus.OK);
	}

	@PostMapping("produto")
	public ResponseEntity<Void> save(@RequestBody ProdutoEntity entity, UriComponentsBuilder builder) {
		ProdutoEntity entitySaved = service.save(entity);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/produto/{identificador}").buildAndExpand(entitySaved.getIdentificador()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("produto")
	public ResponseEntity<ProdutoEntity> update(@RequestBody ProdutoEntity entity) {
		service.update(entity);
		return new ResponseEntity<ProdutoEntity>(entity, HttpStatus.OK);
	}

	@DeleteMapping("produto/{identificador}")
	public ResponseEntity<Void> delete(@PathVariable("identificador") Integer identificador) {
		service.delete(identificador);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}