package br.com.livraria.service.impl;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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
	public void salvar(Livro livro){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(livro.getAutor() == null) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Favor, informe ao menos um autor para o livro a ser cadastrado", ""));
				return;
			}
			if(livro.getId() == null) {
				this.serviceLivro.salvar(livro);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Livro cadastrado com sucesso!", ""));
			}else {
				this.atualizar(livro);
			}
		} catch (ManipulationException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}

	@Override
	public void atualizar(Livro livro) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.serviceLivro.atualizar(livro);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Os dados do Livro foram atualizados com sucesso!", ""));
		}catch(ManipulationException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}

	@Override
	public void remover(Livro livro) throws ManipulationException{
		Livro livroBanco = this.serviceLivro.buscarPorId(livro.getId());
		
		this.serviceLivro.remover(livroBanco);
	}

}
