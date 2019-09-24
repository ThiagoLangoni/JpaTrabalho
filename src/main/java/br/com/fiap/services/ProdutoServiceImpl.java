package br.com.fiap.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import br.com.fiap.entity.ProdutoEntity;
import br.com.fiap.repository.ProdutoRepository;
import br.com.fiap.service.interfaces.IProdutoService;

@Service
public class ProdutoServiceImpl implements IProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	@Override
	@Cacheable(value = "allProdutosCache", unless = "#result.size() == 0")
	public List<ProdutoEntity> getAll() {
		List<ProdutoEntity> lista = new ArrayList<>();
		repository.findAll().forEach(e -> lista.add(e));
		return lista;
	}

	@Override
	@Cacheable(value = "produtoCache", key = "#identificador")
	public ProdutoEntity getById(Integer identificador) {
		return repository.findById(identificador).get();
	}

	@Override
	@Caching(put = { @CachePut(value = "produtoCache", key = "#entity.identificador") }, evict = {
			@CacheEvict(value = "allProdutosCache", allEntries = true) })
	public ProdutoEntity save(ProdutoEntity entity) {
		return repository.save(entity);
	}

	@Override
	@Caching(put = { @CachePut(value = "produtoCache", key = "#entity.identificador") }, evict = {
			@CacheEvict(value = "allProdutosCache", allEntries = true) })
	public ProdutoEntity update(ProdutoEntity entity) {
		return repository.save(entity);
	}

	@Override
	@Caching(evict = { @CacheEvict(value = "produtoCache", key = "#identificador"),
			@CacheEvict(value = "allProdutosCache", allEntries = true) })
	public void delete(Integer identificador) {
		repository.delete(repository.findById(identificador).get());
	}

}
