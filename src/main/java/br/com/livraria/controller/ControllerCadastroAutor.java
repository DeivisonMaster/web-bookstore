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
	private Autor autorEdicao;
	private ServiceCadastroAutor serviceCadastroAutor;
	
	public ControllerCadastroAutor() {
		this.autor = new Autor();
		this.serviceCadastroAutor = new ServiceCadastroAutorImpl();
	}
	
	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.serviceCadastroAutor.salvar(autor);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Autor cadastrado com sucesso!", ""));
			this.autor = new Autor();
		} catch (ManipulationException e) {
			context.addMessage(null, new FacesMessage(e.getMessage()));
		}
		
		return "cadastroLivro?faces-redirect=true";
	}
	
	public String exibirEdicao() {
		this.autor = this.serviceCadastroAutor.buscaPorId(this.autorEdicao.getId());
		return "editaAutor";
	}
	
	public String editar() {
		this.serviceCadastroAutor.editar(this.autor);
		return "cadastroAutor";
	}
	
	public String excluir(Autor autor) {
		this.serviceCadastroAutor.excluir(autor);
		
		return "cadastroAutor?faces-redirect=true";
	}
	
	public Autor getAutor() {
		return autor;
	}
	
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public Autor getAutorEdicao() {
		return autorEdicao;
	}
	
	public void setAutorEdicao(Autor autorEdicao) {
		this.autorEdicao = autorEdicao;
	}
}
