package br.com.fiap.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.entity.PedidoEntity;
import br.com.fiap.repository.PedidoRepository;
import br.com.fiap.service.interfaces.IPedidoService;

@Service
public class PedidoServiceImpl implements IPedidoService {

	@Autowired
	private PedidoRepository repository;
	
	@Override
	public List<PedidoEntity> getAll() {
		List<PedidoEntity> lista = new ArrayList<>();
		repository.findAll().forEach(e -> lista.add(e));
		return lista;
	}

	@Override
	public PedidoEntity getById(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public PedidoEntity save(PedidoEntity entity) {
		return repository.save(entity);
	}

	@Override
	public PedidoEntity update(PedidoEntity entity) {
		return repository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(repository.findById(id).get());
	}

}
