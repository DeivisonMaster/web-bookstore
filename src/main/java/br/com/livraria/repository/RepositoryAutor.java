package br.com.livraria.repository;

import java.io.Serializable;
import java.util.List;

import br.com.livraria.model.Autor;

public interface RepositoryAutor extends Serializable{
	
	List<Autor> buscaPorTodosOsAutores();

	Autor buscaPorId(Long id);

	void salvar(Autor autor);
	
	void editar(Autor autor);

	void excluir(Autor autor);
}
