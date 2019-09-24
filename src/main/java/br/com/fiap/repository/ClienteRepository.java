package br.com.fiap.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.fiap.entity.ClienteEntity;

public interface ClienteRepository extends CrudRepository<ClienteEntity, Integer> {
}