package br.com.fiap.service.interfaces;

import java.util.List;
import br.com.fiap.entity.PedidoEntity;;

public interface IPedidoService {
	
	List<PedidoEntity> getAll();

	PedidoEntity getById(Integer id);

	PedidoEntity save(PedidoEntity entity);

	PedidoEntity update(PedidoEntity entity);

	void delete(Integer id);
	
}
