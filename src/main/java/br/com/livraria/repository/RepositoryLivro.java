package br.com.livraria.repository;

import java.io.Serializable;
import java.util.List;

import br.com.livraria.model.Livro;

public interface RepositoryLivro extends Serializable {
	
	void salvar(Livro livro);

	void atualizar(Livro livro);
	
	Livro buscarPorId(Long id);
	
	List<Livro> buscarPorTodosOsLivros();

	void remover(Livro livro);
}
