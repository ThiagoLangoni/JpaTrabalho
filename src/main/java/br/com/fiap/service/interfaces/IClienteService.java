package br.com.fiap.service.interfaces;

import java.util.List;
import br.com.fiap.entity.ClienteEntity;

public interface IClienteService {
	
	List<ClienteEntity> getAll();

	ClienteEntity getById(Integer id);

	ClienteEntity save(ClienteEntity entity);

	ClienteEntity update(ClienteEntity entity);

	void delete(Integer id);
	
}
