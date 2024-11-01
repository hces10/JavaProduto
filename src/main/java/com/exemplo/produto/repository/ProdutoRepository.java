package com.exemplo.produto.repository;

import com.exemplo.produto.entity.Produto;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ProdutoRepository extends Repository<Produto, Long> {

    void save(Produto Produto);

    List<Produto> findByPrecoGreaterThan(long id);

    List<Produto> findAll();

    void deleteById(long id);
}