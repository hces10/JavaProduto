package com.exemplo.produto.service;

import com.exemplo.produto.entity.Produto;
import com.exemplo.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public void adicionarProduto(Produto produto) {
        if (produto.getPreco() <= 1) {
            throw new IllegalArgumentException("O preço do produto deve ser maior que 1");
        }
        produtoRepository.save(produto);
    }

    @Override
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public void deletarProduto(long id) {
        produtoRepository.deleteById(id);
    }

    public List<Produto> listarProdutosPrecoMaior(long preco) {
        return produtoRepository.findByPrecoGreaterThan(preco);
    }

    public List<Produto> listarProdutosPaginados(long preco,int page, int size, String order) {
        List<Produto> data = produtoRepository.findByPrecoGreaterThan(preco);

        if (order != null && order.equals("asc")) {
            data.sort(Comparator.comparing(Produto::getNome, Comparator.naturalOrder()));
        } else if (order != null && order.equals("desc")) {
            data.sort(Comparator.comparing(Produto::getNome, Comparator.reverseOrder()));
        }

        Pageable pageable = PageRequest.of(page, size);
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), data.size());

        return data.subList(start, end);
    }
}
