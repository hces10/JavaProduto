package com.exemplo.produto.repository;

import com.exemplo.produto.entity.Produto;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends Repository<Produto, Long> {

    Produto save(Produto Produto);

    Optional<Produto> findById(long id);

    List<Produto> findAll();
}