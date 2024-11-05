package com.exemplo.produto.controller;

import com.exemplo.produto.entity.Categoria;
import com.exemplo.produto.service.CategoriaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/listarCategorias")
    public List<Categoria> listarCategorias() {
        return categoriaService.listarCategorias();
    }

    @PostMapping("/adicionarCategoria")
    public ResponseEntity adicionarCategoria(@RequestBody Categoria categoria) {
        categoriaService.adicionarCategoria(categoria);
        return new ResponseEntity("Categoria adicionada com sucesso", HttpStatus.CREATED);
    }

    @DeleteMapping("/deletarCategoria/{id}")
    public ResponseEntity deletarCategoria(@PathVariable long id) {
        categoriaService.deletarCategoria(id);
        return new ResponseEntity("Categoria deletada com sucesso", HttpStatus.OK);
    }
}
