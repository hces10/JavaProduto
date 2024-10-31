package com.exemplo.produto;

import com.exemplo.produto.entity.Produto;
import com.exemplo.produto.repository.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class ProdutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdutoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@Bean
	CommandLineRunner runner(ProdutoRepository repository) {
		return args -> {

			Produto produto = new Produto();
			produto.setNome("Bolacha");
			produto.setPreco(4.99);

			repository.save(produto);
			Produto saved = repository.findById(produto.getId()).orElseThrow(RuntimeException::new);
			List<Produto> produtos = repository.findAll();

		};
	}

}
