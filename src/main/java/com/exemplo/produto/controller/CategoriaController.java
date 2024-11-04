package com.exemplo.produto.controller;

import com.exemplo.produto.entity.Categoria;
import com.exemplo.produto.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/listarCategorias")
    public void listarCategorias() {
        categoriaService.listarCategorias();
    }

    @PostMapping("/adicionarCategoria")
    public void adicionarCategoria(@RequestBody Categoria categoria) {
        categoriaService.adicionarCategoria(categoria);
    }

    @DeleteMapping("/deletarCategoria/{id}")
    public void deletarCategoria(@PathVariable long id) {
        categoriaService.deletarCategoria(id);
    }
}
