package br.com.livraria.service;

import br.com.livraria.model.Autor;
import br.com.livraria.util.ManipulationException;

public interface ServiceCadastroAutor {

	void salvar(Autor autor) throws ManipulationException;

	Autor edita(Long id);
	
	void editar(Autor autor);
	
	Autor buscaPorId(Long id);

	void excluir(Autor autor);
	
}
