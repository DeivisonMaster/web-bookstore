package br.com.livraria.service;

import java.io.Serializable;
import java.util.List;

import br.com.livraria.model.Autor;
import br.com.livraria.util.ManipulationException;

public interface ServiceAutor extends Serializable{
	
	List<Autor> buscaPorTodosOsAutores();
	
	Autor buscaPorId(Long id);

	void salvar(Autor autor) throws ManipulationException;

	void editar(Autor autor);

	void excluir(Autor autor) throws ManipulationException;
}
