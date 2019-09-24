package br.com.fiap.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.fiap.entity.PedidoEntity;

public interface PedidoRepository extends CrudRepository<PedidoEntity, Integer> {
}