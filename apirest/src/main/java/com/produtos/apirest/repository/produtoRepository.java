package com.produtos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.models.Produto;

public interface produtoRepository extends JpaRepository<Produto, Long> {
	
}
