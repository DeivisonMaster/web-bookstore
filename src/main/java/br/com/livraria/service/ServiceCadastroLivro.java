package br.com.livraria.service;

import java.io.Serializable;

import br.com.livraria.model.Livro;
import br.com.livraria.util.ManipulationException;
import br.com.livraria.util.NegocioException;

public interface ServiceCadastroLivro extends Serializable{
	
	void salvar(Livro livro);
	
	void atualizar(Livro livro);
	
	void remover(Livro livro) throws ManipulationException;
	
}
