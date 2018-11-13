package br.com.livraria.service.impl;

import br.com.livraria.model.Livro;
import br.com.livraria.service.ServiceCadastroLivro;
import br.com.livraria.service.ServiceLivro;
import br.com.livraria.util.ManipulationException;
import br.com.livraria.util.NegocioException;

public class ServiceCadastroLivroImpl implements ServiceCadastroLivro{
	
	private ServiceLivro serviceLivro;
	
	public ServiceCadastroLivroImpl() {
		this.serviceLivro = new ServiceLivroImpl();
	}

	@Override
	public void salvar(Livro livro) throws NegocioException, ManipulationException{
		if(livro.getAutor() == null) {
			throw new NegocioException("Favor, informe ao menos um autor para o livro a ser cadastrado");
		}
		this.serviceLivro.salvar(livro);
	}

	@Override
	public void atualizar(Long id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void remover(Livro livro) throws ManipulationException{
		Livro livroBanco = this.serviceLivro.buscarPorId(livro.getId());
		
		this.serviceLivro.remover(livroBanco);
	}

}
