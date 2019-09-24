package br.com.fiap.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.entity.ItemEntity;
import br.com.fiap.repository.ItemRepository;
import br.com.fiap.service.interfaces.IItemService;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private ItemRepository repository;
	
	@Override
	public List<ItemEntity> getAll() {
		List<ItemEntity> lista = new ArrayList<>();
		repository.findAll().forEach(e -> lista.add(e));
		return lista;
	}

	@Override
		public ItemEntity getById(Integer identificador) {
		return repository.findById(identificador).get();
	}

	@Override
	public ItemEntity save(ItemEntity entity) {
		return repository.save(entity);
	}

	@Override
	public ItemEntity update(ItemEntity entity) {
		return repository.save(entity);
	}

	@Override
		public void delete(Integer identificador) {
		repository.delete(repository.findById(identificador).get());
	}

}
