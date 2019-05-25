package br.com.livraria.service.impl;

import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.livraria.model.Livro;
import br.com.livraria.service.ServiceCadastroLivro;
import br.com.livraria.service.ServiceLivro;
import br.com.livraria.util.ManipulationException;
import br.com.livraria.util.NegocioException;

@Dependent
public class ServiceCadastroLivroImpl implements ServiceCadastroLivro{
	private static final long serialVersionUID = 1L;

	@Inject
	private ServiceLivro serviceLivro;
	
	@Inject
	private FacesContext context;
	
	
	@Override
	public void salvar(Livro livro){
		try {
			if(livro.getAutor() == null) {
				this.context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Favor, informe ao menos um autor para o livro a ser cadastrado", ""));
				return;
			}
			if(livro.getId() == null) {
				this.serviceLivro.salvar(livro);
				this.context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Livro cadastrado com sucesso!", ""));
			}else {
				this.atualizar(livro);
			}
		} catch (ManipulationException e) {
			this.context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}

	@Override
	public void atualizar(Livro livro) {
		try {
			this.serviceLivro.atualizar(livro);
			this.context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Os dados do Livro foram atualizados com sucesso!", ""));
		}catch(ManipulationException e) {
			this.context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}

	@Override
	public void remover(Livro livro) throws ManipulationException{
		Livro livroBanco = this.serviceLivro.buscarPorId(livro.getId());
		
		this.serviceLivro.remover(livroBanco);
	}

}
