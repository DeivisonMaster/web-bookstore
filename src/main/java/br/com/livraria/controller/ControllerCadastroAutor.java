package br.com.livraria.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.livraria.model.Autor;
import br.com.livraria.service.ServiceCadastroAutor;
import br.com.livraria.service.impl.ServiceCadastroAutorImpl;
import br.com.livraria.util.ManipulationException;

@ManagedBean
@RequestScoped
public class ControllerCadastroAutor {
	
	private Autor autor;
	private ServiceCadastroAutor serviceCadastroAutor;
	
	public ControllerCadastroAutor() {
		this.autor = new Autor();
		this.serviceCadastroAutor = new ServiceCadastroAutorImpl();
	}
	
	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.serviceCadastroAutor.salvar(autor);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Autor cadastrado com sucesso!", ""));
			this.autor = new Autor();
		} catch (ManipulationException e) {
			context.addMessage(null, new FacesMessage(e.getMessage()));
		}
	}
	
	public Autor getAutor() {
		return autor;
	}
	
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
}
