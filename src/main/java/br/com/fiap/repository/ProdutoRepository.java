package br.com.fiap.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.fiap.entity.ProdutoEntity;;

public interface ProdutoRepository extends CrudRepository<ProdutoEntity, Integer> {
}