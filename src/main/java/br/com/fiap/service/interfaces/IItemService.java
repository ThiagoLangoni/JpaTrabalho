package br.com.fiap.service.interfaces;

import java.util.List;
import br.com.fiap.entity.ItemEntity;

public interface IItemService {
	
	List<ItemEntity> getAll();

	ItemEntity getById(Integer id);

	ItemEntity save(ItemEntity entity);

	ItemEntity update(ItemEntity entity);

	void delete(Integer id);
	
}
