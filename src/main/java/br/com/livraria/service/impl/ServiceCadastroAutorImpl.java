package br.com.livraria.service.impl;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.livraria.model.Autor;
import br.com.livraria.service.ServiceAutor;
import br.com.livraria.service.ServiceCadastroAutor;
import br.com.livraria.util.ManipulationException;

public class ServiceCadastroAutorImpl implements ServiceCadastroAutor {
	private static final long serialVersionUID = 1L;
	
	private ServiceAutor serviceAutor;

	public ServiceCadastroAutorImpl() {
		this.serviceAutor = new ServiceAutorImpl();
	}

	@Override
	public void salvar(Autor autor) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(autor.getId() == null) {
				this.serviceAutor.salvar(autor);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Autor cadastrado com sucesso!", ""));
			}else {
				this.editar(autor);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Dados atualizados com sucesso!", ""));
			}
		} catch (ManipulationException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}

	@Override
	public Autor edita(Long id) {
		return this.serviceAutor.buscaPorId(id);
	}

	@Override
	public void editar(Autor autor) {
		this.serviceAutor.editar(autor);
	}

	@Override
	public Autor buscaPorId(Long id) {
		return this.serviceAutor.buscaPorId(id);
	}

	@Override
	public void excluir(Autor autor){
		FacesContext context = FacesContext.getCurrentInstance();
		Autor buscaAutor = this.buscaPorId(autor.getId());
		
		try {
			this.serviceAutor.excluir(buscaAutor);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Autor excluido com sucesso!", ""));
		} catch (ManipulationException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}

}
