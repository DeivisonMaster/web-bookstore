package br.com.livraria.service;

import java.util.List;

import br.com.livraria.model.Livro;
import br.com.livraria.util.ManipulationException;

public interface ServiceLivro {

	void salvar(Livro livro) throws ManipulationException;

	void atualizar(Livro livro)  throws ManipulationException;

	List<Livro> buscaPorTodosOsLivros();
	
	Livro buscarPorId(Long id);

	void remover(Livro livro) throws ManipulationException;
	
}
