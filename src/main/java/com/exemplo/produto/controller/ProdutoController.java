package com.exemplo.produto.controller;

import com.exemplo.produto.entity.Produto;
import com.exemplo.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @PostMapping("/adicionarProduto")
    public ResponseEntity adicionarProduto(@RequestBody Produto produto) {
        try {
            produtoService.adicionarProduto(produto);
            return new ResponseEntity("Produto adicionado com sucesso", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listarProdutos")
    public ResponseEntity listarProdutos() {
        return new ResponseEntity(produtoService.listarProdutos(), HttpStatus.OK);
    }

    @DeleteMapping("/deletarProduto/{id}")
    public ResponseEntity deletarProduto(@PathVariable long id) {
        produtoService.deletarProduto(id);
        return new ResponseEntity("Produto deletado com sucesso", HttpStatus.OK);
    }

    @GetMapping("/produtos")
    public ResponseEntity listarProdutosPrecoMaior(@RequestParam long precoMinimo) {
        return new ResponseEntity(produtoService.listarProdutosPrecoMaior(precoMinimo), HttpStatus.OK);
    }
}
