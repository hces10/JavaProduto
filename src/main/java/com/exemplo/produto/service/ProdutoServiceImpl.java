package com.exemplo.produto.service;

import com.exemplo.produto.entity.Produto;
import com.exemplo.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    ProdutoRepository repository;

    @Autowired
    ProdutoService produtoService;

    public void adicionarProduto(String nome, double preco) {
        repository.save(new Produto(nome, preco));
    }

    public void listarProdutos() {
        repository.findAll();
    }
}
