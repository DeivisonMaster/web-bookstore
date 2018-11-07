package br.com.livraria.service;

import br.com.livraria.model.Autor;
import br.com.livraria.util.ManipulationException;

public interface ServiceCadastroAutor {

	void salvar(Autor autor) throws ManipulationException;

}
