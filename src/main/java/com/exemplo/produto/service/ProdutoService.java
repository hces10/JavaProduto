package com.exemplo.produto.service;


import com.exemplo.produto.entity.Produto;

import java.util.List;

public interface ProdutoService {
    public void adicionarProduto(Produto produto);
    public void deletarProduto(long id);
    public List<Produto> listarProdutos();
    public List<Produto> listarProdutosPaginados(long preco, int page, int size, String order);
    public List<Produto> listarProdutosPrecoMaior(long preco);
}
