package com.exemplo.produto.service;

import com.exemplo.produto.entity.Categoria;
import com.exemplo.produto.repository.CategoriaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    public void adicionarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public void deletarCategoria(long id) {
        categoriaRepository.deleteById(id);
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

}

