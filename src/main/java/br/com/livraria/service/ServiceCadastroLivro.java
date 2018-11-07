package br.com.livraria.service;

import br.com.livraria.model.Livro;
import br.com.livraria.util.ManipulationException;
import br.com.livraria.util.NegocioException;

public interface ServiceCadastroLivro {
	
	void salvar(Livro livro) throws NegocioException, ManipulationException;
	
	void atualizar(Long id);
	
}
