package br.com.fiap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.fiap.entity.PedidoEntity;
import br.com.fiap.service.interfaces.IPedidoService;

@RestController
@RequestMapping("Cadastro")
public class PedidoController {

	@Autowired
	private IPedidoService service;

	@RequestMapping("TestePedido")
	public String greeting() {
		return "Teste!";
	}

	@GetMapping("pedido/{identificador}")
	public ResponseEntity<PedidoEntity> getById(@PathVariable("identificador") Integer identificador) {
		PedidoEntity entity = service.getById(identificador);
		return new ResponseEntity<PedidoEntity>(entity, HttpStatus.OK);
	}

	@GetMapping("pedidos")
	public ResponseEntity<List<PedidoEntity>> getAll() {
		List<PedidoEntity> lista = service.getAll();
		return new ResponseEntity<List<PedidoEntity>>(lista, HttpStatus.OK);
	}

	@PostMapping("pedido")
	public ResponseEntity<PedidoEntity> save(@RequestBody PedidoEntity entity, UriComponentsBuilder builder) {
		service.save(entity);
		return new ResponseEntity<PedidoEntity>(entity, HttpStatus.OK);
	}

	@PutMapping("pedido")
	public ResponseEntity<PedidoEntity> update(@RequestBody PedidoEntity entity) {
		service.update(entity);
		return new ResponseEntity<PedidoEntity>(entity, HttpStatus.OK);
	}

	@DeleteMapping("pedido/{identificador}")
	public ResponseEntity<Void> delete(@PathVariable("identificador") Integer identificador) {
		service.delete(identificador);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}