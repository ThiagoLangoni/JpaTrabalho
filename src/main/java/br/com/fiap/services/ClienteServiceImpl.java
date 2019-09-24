package br.com.fiap.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import br.com.fiap.entity.ClienteEntity;
import br.com.fiap.repository.ClienteRepository;
import br.com.fiap.service.interfaces.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Override
	@Cacheable(value = "allClientesCache", unless = "#result.size() == 0")
	public List<ClienteEntity> getAll() {
		List<ClienteEntity> lista = new ArrayList<>();
		repository.findAll().forEach(e -> lista.add(e));
		return lista;
	}

	@Override
	@Cacheable(value = "clienteCache", key = "#identificador")
	public ClienteEntity getById(Integer identificador) {
		return repository.findById(identificador).get();
	}

	@Override
	@Caching(put = { @CachePut(value = "clienteCache", key = "#entity.identificador") }, evict = {
			@CacheEvict(value = "allClientesCache", allEntries = true) })
	public ClienteEntity save(ClienteEntity entity) {
		return repository.save(entity);
	}

	@Override
	@Caching(put = { @CachePut(value = "clienteCache", key = "#entity.identificador") }, evict = {
			@CacheEvict(value = "allClientesCache", allEntries = true) })
	public ClienteEntity update(ClienteEntity entity) {
		return repository.save(entity);
	}

	@Override
	@Caching(evict = { @CacheEvict(value = "clienteCache", key = "#identificador"),
			@CacheEvict(value = "allClientesCache", allEntries = true) })
	public void delete(Integer identificador) {
		repository.delete(repository.findById(identificador).get());
	}
}
