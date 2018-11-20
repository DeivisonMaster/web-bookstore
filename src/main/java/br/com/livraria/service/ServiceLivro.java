package br.com.livraria.service;

import java.io.Serializable;
import java.util.List;

import br.com.livraria.model.Livro;
import br.com.livraria.util.ManipulationException;

public interface ServiceLivro extends Serializable {

	void salvar(Livro livro) throws ManipulationException;

	void atualizar(Livro livro)  throws ManipulationException;

	List<Livro> buscaPorTodosOsLivros() throws ManipulationException;
	
	Livro buscarPorId(Long id);

	void remover(Livro livro) throws ManipulationException;
	
}
