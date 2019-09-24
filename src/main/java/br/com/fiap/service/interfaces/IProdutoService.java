package br.com.fiap.service.interfaces;

import java.util.List;
import br.com.fiap.entity.ProdutoEntity;;;

public interface IProdutoService {
	
	List<ProdutoEntity> getAll();

	ProdutoEntity getById(Integer id);

	ProdutoEntity save(ProdutoEntity entity);

	ProdutoEntity update(ProdutoEntity entity);

	void delete(Integer id);
	
}
