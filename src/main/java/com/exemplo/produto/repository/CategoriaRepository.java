package com.exemplo.produto.repository;

import com.exemplo.produto.entity.Categoria;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface CategoriaRepository extends Repository<Categoria, Long> {
    public void save(Categoria categoria);
    public void deleteById(long id);
    public List<Categoria> findAll();
}
