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

import br.com.fiap.entity.ItemEntity;
import br.com.fiap.service.interfaces.IItemService;

@RestController
@RequestMapping("Cadastro")
public class ItemController {
	
	@Autowired
	private IItemService service;

	@RequestMapping("TesteItem")
	public String greeting() {
		return "Teste!";
	}

	@GetMapping("item/{identificador}")
	public ResponseEntity<ItemEntity> getById(@PathVariable("identificador") Integer identificador) {
		ItemEntity entity = service.getById(identificador);
		return new ResponseEntity<ItemEntity>(entity, HttpStatus.OK);
	}

	@GetMapping("items")
	public ResponseEntity<List<ItemEntity>> getAll() {
		List<ItemEntity> lista = service.getAll();
		return new ResponseEntity<List<ItemEntity>>(lista, HttpStatus.OK);
	}

	@PostMapping("item")
	public ResponseEntity<Void> save(@RequestBody ItemEntity entity, UriComponentsBuilder builder) {
		ItemEntity entitySaved = service.save(entity);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/cliente/{id}").buildAndExpand(entitySaved.getIdentificador()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("item")
	public ResponseEntity<ItemEntity> update(@RequestBody ItemEntity entity) {
		service.update(entity);
		return new ResponseEntity<ItemEntity>(entity, HttpStatus.OK);
	}

	@DeleteMapping("item/{identificador}")
	public ResponseEntity<Void> delete(@PathVariable("identificador") Integer identificador) {
		service.delete(identificador);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}