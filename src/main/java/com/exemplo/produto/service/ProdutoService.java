package com.exemplo.produto.service;


import com.exemplo.produto.entity.Produto;

import java.util.List;

public interface ProdutoService {
    public void adicionarProduto(Produto produto);
    public void deletarProduto(long id);
    public List<Produto> listarProdutos();
}
