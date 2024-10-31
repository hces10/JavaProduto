package com.exemplo.produto.service;

import com.exemplo.produto.entity.Produto;
import com.exemplo.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public void adicionarProduto(Produto produto) {
        produtoRepository.save(produto);
    }

    @Override
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public void deletarProduto(long id) {
        produtoRepository.deleteById(id);
    }
}
