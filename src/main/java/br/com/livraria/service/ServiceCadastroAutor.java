package br.com.livraria.service;

import java.io.Serializable;

import br.com.livraria.model.Autor;
import br.com.livraria.util.ManipulationException;

public interface ServiceCadastroAutor extends Serializable{

	void salvar(Autor autor);

	Autor edita(Long id);
	
	void editar(Autor autor);
	
	Autor buscaPorId(Long id);

	void excluir(Autor autor);
	
}
