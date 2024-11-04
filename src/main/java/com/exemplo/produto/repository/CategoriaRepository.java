package com.exemplo.produto.repository;

import com.exemplo.produto.entity.Categoria;

import java.util.List;

public interface CategoriaRepository {
    public void adicionarCategoria(Categoria categoria);
    public void deletarCategoria(long id);
    public List<Categoria> listarCategorias();
}
