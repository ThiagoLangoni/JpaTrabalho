package br.com.fiap.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.fiap.entity.ItemEntity;;

public interface ItemRepository extends CrudRepository<ItemEntity, Integer> {
}