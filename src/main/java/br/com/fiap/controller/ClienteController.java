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

import br.com.fiap.entity.ClienteEntity;
import br.com.fiap.service.interfaces.IClienteService;

@RestController
@RequestMapping("Cadastro")
public class ClienteController {
	
	@Autowired
	private IClienteService service;

	@RequestMapping("TesteCliente")
	public String greeting() {
		return "Teste!";
	}

	@GetMapping("cliente/{identificador}")
	public ResponseEntity<ClienteEntity> getById(@PathVariable("identificador") Integer identificador) {
		ClienteEntity entity = service.getById(identificador);
		return new ResponseEntity<ClienteEntity>(entity, HttpStatus.OK);
	}

	@GetMapping("clientes")
	public ResponseEntity<List<ClienteEntity>> getAll() {
		List<ClienteEntity> lista = service.getAll();
		return new ResponseEntity<List<ClienteEntity>>(lista, HttpStatus.OK);
	}

	@PostMapping("cliente")
	public ResponseEntity<Void> save(@RequestBody ClienteEntity entity, UriComponentsBuilder builder) {
		ClienteEntity entitySaved = service.save(entity);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/cliente/{identificador}").buildAndExpand(entitySaved.getIdentificador()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("cliente")
	public ResponseEntity<ClienteEntity> update(@RequestBody ClienteEntity entity) {
		service.update(entity);
		return new ResponseEntity<ClienteEntity>(entity, HttpStatus.OK);
	}

	@DeleteMapping("cliente/{identificador}")
	public ResponseEntity<Void> delete(@PathVariable("identificador") Integer identificador) {
		service.delete(identificador);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}